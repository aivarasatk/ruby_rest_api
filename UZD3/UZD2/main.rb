require 'sinatra/base'
require 'json'
require_relative 'DTO/LanguageDTO'
require_relative 'Services/LanguageService'
require_relative 'Services/ValidationService'
require_relative 'Services/NotesService'

class RequestHelper < Sinatra::Application
	attr_reader :languageService
	attr_reader :validationSerivice
	attr_reader :notesService
	
	def initialize
		@languageService = LanguageService.new
		@validationSerivice = ValidationService.new
		@notesService = NotesService.new
		
		# ?embedded=notes grazina all
		# default data
		
		notesService.postNote(defaultData('default1'))
		languageService.addNoteForLanguage(1, 'default1')
		notesService.postNote(defaultData('default2'))
		languageService.addNoteForLanguage(1, 'default2')
		
		notesService.postNote(defaultData('default21'))
		languageService.addNoteForLanguage(2, 'default21')
		notesService.postNote(defaultData('default22'))
		languageService.addNoteForLanguage(2, 'default22')
	end
	
	get '/languages' do
		embedded = params['embedded']
		langId = params['id']
		
		response.headers['Content-Type'] = "application/json"
		if embedded == 'notes' then
				id = nil
				begin
					id = Integer(langId)
				rescue
					status 404
					response.body = '{"message":"Failed id parse"}'
					return
				end
				language = languageService.getLanguage(id)
				if language == nil then 
					status 404
					message = {"messsage" => "Language does not exist"}
					response.body = JSON.generate message
					return
				end
				fakeArray = []
				fakeArray.push(language)
				fakeArrayCopy = fakeArray.map(&:clone)
				
				notes = []
				noteTitles = fakeArrayCopy[0].notes
				noteTitles.each{ |title|
					begin
						res = notesService.getNoteForTitle(title)
						if res.code.to_i == 200 then
							resData = (JSON.parse res.body)['data']
							notes.push(resData)
						end
					rescue
						message = {"messsage" => "Could not get a response from service"}
						notes = [message]
						break
					end
				}
				
				fakeArrayCopy[0].notes = notes
				
				fakeArray2.push(fakeArrayCopy[0])
				status 200
				response.body = JSON.generate fakeArray2
				return
			else
				languages = languageService.getLanguages
				languagesAndNotes = languages.map(&:clone)
				languages.each{ |language|
					notes = []
					noteTitles = language.notes
					noteTitles.each{ |title|
						begin
							res = notesService.getNoteForTitle(title)
							if res.code.to_i == 200 then
								resData = (JSON.parse res.body)['data']
								notes.push(resData)
							end
						rescue
							message = {"messsage" => "Could not get a response from service"}
							notes = [message]
							break
						end
					}
					
					languagesAndNotes.each{ |withNotes|
						if withNotes.id == language.id then
							withNotes.notes = notes
						end
					}
					
				}
				status 200
				response.body = JSON.generate languagesAndNotes
			end
		else
			status 200
			response.body = languageService.getAllAsJson
		end
	end
	
	get '/languages/:id' do
		languageId = params['id']
		response.headers['Content-Type'] = "application/json"
		begin
			id = Integer(languageId)
			language = languageService.getByIdAsJson(id)
			if language.nil? then
				status 404
				response.body '{"message":"Invalid id"}'
			else
				response.body = language
				status 200
			end
		rescue
			status 404
			response.body = '{"message":"Invalid id"}'
		end
	end
	
	get '/languages/:id/notes' do
		languageId = params['id']
		response.headers['Content-Type'] = "application/json"
		
		id = nil
		begin
			id = Integer(languageId)
		rescue
			status 404
			response.body = '{"message":"Failed id parse"}'
			return
		end
		
		if !languageService.languageExists(id) then
			status 404
			response.body '{"message":"Invalid id"}'
		else
			notes = []
			noteTitles = languageService.getNotesForLanguage(id)
			noteTitles.each{ |title|
				begin
					res = notesService.getNoteForTitle(title)
					if res.code.to_i == 200 then
						resData = (JSON.parse res.body)['data']
						notes.push(resData)
					end
				rescue
					status 500
					response.body = '{"message":"Could not get a response from service"}'
					return
				end
			}
			status 200
			response.body = JSON.generate notes
			return
		end
		
	end
		
	post '/languages/:id' do
		status 405	
	end
	
	post '/languages' do
		bodyJson = ""
		response.headers['Content-Type'] = "application/json"
		request.body.rewind
		begin
			bodyJson = JSON.parse request.body.read
		rescue
			status 400
			response.body ='{"message":"Failed to parse the payload"}'
			return
		end
		
		if validationSerivice.isPostDataValid(bodyJson) then
			nextId = Array(languageService.addLanguage(bodyJson))
			response.body = "{\"message\": \"New item(s) can be accessed using the id(s)\", \"id\":#{nextId}}"
			
			url = request.host_with_port + "/languages"
			response.headers['Location'] = nextId.map { |id| "#{url}/#{id}" }.join(",")
		else
			status 400
			response.body = '{"message":"Request body does not meet the criteria"}'
		end
		return
	end
	
	post '/languages/:id/notes' do
		response.headers['Content-Type'] = "application/json"

		begin
			id = Integer(params['id'])
			if !languageService.languageExists(id) then
				status 404
				response.body '{"message":"Invalid id"}'
			else
				request.body.rewind
				bodyJson = request.body.read
				
				res = nil
				begin
					res = notesService.postNote(bodyJson)
				rescue
					status 500
					response.body = '{"message":"Could not get a response from service"}'
					return
				end
				
				if res.code.to_i != 201 then
					status 400
					response.body ="{\"message\":\"#{res.message}\"}"
					return
				else
					responseJson = JSON.parse res.body
					languageService.addNoteForLanguage(id, responseJson['data']['title'])
					status 201
					response.body ='{"message":"Created a note"}'
					return
				end
			end
		rescue
			status 404
			response.body = '{"message":"Failed to parse id"}'
		end
	end
	
	delete '/languages/:id' do
		response.headers['Content-Type'] = "application/json"
		begin
			id = Integer(params['id'])
			if languageService.removeLanguage(id) then
				response.body = '{"message":"Item removed"}'
				status 200
			else
				status 404
				response.body = '{"message":"Invalid id"}'
			end
		rescue
			status 404
			response.body = '{"message":"Invalid id"}'
		end
		
	end
	
	delete '/languages/:id/notes/:noteTitle' do
		response.headers['Content-Type'] = "application/json"
		title = params['noteTitle']
		begin
			id = Integer(params['id'])
			if languageService.languageExists(id) && languageService.languageHasNoteTitle(id, params['noteTitle']) then
				begin
					res = notesService.deleteNote(title)
					if res.code.to_i == 200 then
						languageService.removeNoteForLanguage(title, id)
						status 200
						response.body = '{"message":"Successfully removed note"}'
					else
						status res.code.to_i
						response.body = "{\"message\":\"#{res.message}\"}"
					end
				rescue
					status 500
					response.body = '{"message":"Could not get a response from service"}'
					return
				end
			else
				status 404
				response.body = '{"message":"Id or note title does not exist"}'
			end
		rescue
			status 404
			response.body = '{"message":"Invalid id"}'
		end
		
	end
	
	delete '/languages' do
		status 405	
	end
	
	delete '/languages/:id/notes' do
		status 405	
	end
	
	put '/languages/:id' do
		response.headers['Content-Type'] = "application/json"
		begin
			id = Integer(params['id'])
			
			request.body.rewind
			bodyJson = JSON.parse request.body.read
		rescue
			status 400
			response.body ='{"message":"Failed to parse the payload or id"}'
			return
		end
		
		if !languageService.languageExists(id) then
			status 400
			response.body ='{"message":"Language with id does not exist"}'
			return
		end
		
		if validationSerivice.isPutDataValid(id, bodyJson) then
			if languageService.updateLanguage(bodyJson, id) then
				response.body = '{"message":"Item updated"}'
			else
				status 400
				response.body = '{"message":"Failed to update item"}'
			end
		else
			status 400
			response.body = '{"message":"Invalid body"}'
		end
		
	end
			
	put '/languages' do
		status 405		
	end
	
	put '/languages/:id/notes' do
		status 405
	end
	
	patch '/languages/:id' do
		response.headers['Content-Type'] = "application/json"
		begin
			id = Integer(params['id'])
			
			request.body.rewind
			bodyJson = JSON.parse request.body.read
		rescue
			status 400
			response.body ='{"message":"Failed to parse the payload or id"}'
			return
		end
		
		if !languageService.languageExists(id) then
			status 400
			response.body ='{"message":"Language with id does not exist"}'
			return
		end
		
		if validationSerivice.isPatchDataValid(bodyJson) then
			if languageService.patchLanguage(bodyJson, id) then
				response.body = '{"message":"Item updated"}'
			else
				status 400
				response.body = '{"message":"Failed to update item"}'
			end
		else
			status 400
			response.body = '{"message":"Invalid body"}'
		end
	end
	
	patch '/languages' do
		status 405
	end
	patch '/languages/:id/notes' do
		status 405
	end
			
	
	def defaultData(title)
		'{"title":"' + title + '","author":"aiv","comment":"new one","expiration":"2020-12-12"}'
	end
	
	run! if app_file == $0
end

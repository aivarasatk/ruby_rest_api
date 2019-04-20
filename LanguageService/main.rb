require 'sinatra/base'
require 'json'
require_relative 'DTO/LanguageDTO'
require_relative 'Services/LanguageService'
require_relative 'Services/ValidationService'

class RequestHelper < Sinatra::Application
	attr_reader :languageService
	attr_reader :validationSerivice
	
	def initialize
		@languageService = LanguageService.new
		@validationSerivice = ValidationService.new
	end
	
	get '/languages' do
		isStronglyType = params['strongly_typed']
		releaseYear = params['release_year'].to_i
		
		response.headers['Content-Type'] = "application/json"
		if params['release_year']==nil && params['strongly_typed'] == nil then
			response.body = languageService.getAllAsJson
		else
			response.body = languageService.getMatches(releaseYear, isStronglyType)
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
			end
		rescue
			status 404
			response.body = '{"message":"Invalid id"}'
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
	
	delete '/languages/:id' do
		response.headers['Content-Type'] = "application/json"
		begin
			id = Integer(params['id'])
			if languageService.removeLanguage(id) then
				response.body = '{"message":"Item removed"}'
			else
				status 404
				response.body = '{"message":"Invalid id"}'
			end
		rescue
			status 404
			response.body = '{"message":"Invalid id"}'
		end
		
	end
	
	delete '/languages' do
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
			
	patch '/languages' do
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
		
	
	
	run! if app_file == $0
end

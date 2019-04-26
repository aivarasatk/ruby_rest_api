require 'net/http'
class NotesService
	@@notesUrl = 'http://193.219.91.103:6725/notes'
	
	def getNotesForLanguageId(id)
		urlWithId = @@notesUrl + "/" + id
	end
	
	def postNote(note)
		uri = URI(@@notesUrl)

		req = Net::HTTP::Post.new(uri)
		req['Content-Type'] = 'application/json'
		req.body = note
		res = Net::HTTP.start(uri.hostname, uri.port) do |http|
		  http.request(req)
		end
		res
	end
	
	def getNoteForTitle(title)
		uri = URI(@@notesUrl + '/' + title)

		req = Net::HTTP::Get.new(uri)
		res = Net::HTTP.start(uri.hostname, uri.port) do |http|
		  http.request(req)
		end
		res
	end
	
	def deleteNote(title)
		uri = URI(@@notesUrl + '/' + title)

		req = Net::HTTP::Delete.new(uri)
		res = Net::HTTP.start(uri.hostname, uri.port) do |http|
		  http.request(req)
		end
		res
	end
end

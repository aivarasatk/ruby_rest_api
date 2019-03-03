require 'sinatra/base'
require_relative 'DTO/LanguageDTO'

class RequestHelper < Sinatra::Application
	
	get '/languages' do
		#return all languages that are:
		# * object-oriented
		# * supported by popular editors
		# * are released in selected year
		isOOP = params['oop']
		editor = params['supported_editor']
		releaseYear = params['release_year']
		
		if isOOP==nil && editor==nil && releaseYear==nil then
			'all'#return all
		else
			#match all languages by given params
			'matched'
		end
	end
	
	post '/languages' do
		body = request.body
		#add the new language unless body is completely empty
		#return a path to access the new language
	end
	
	run! if app_file == $0
end
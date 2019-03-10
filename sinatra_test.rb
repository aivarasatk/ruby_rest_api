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
		if releaseYear==nil && isStronglyType == nil then
			languageService.getAllAsJson
		else
			languageService.getMatches(releaseYear, isStronglyType)
		end
	end
	
	post '/languages' do
		body = request.body
		#add the new language unless body is completely empty
		#return a path to access the new language
	end
	
	run! if app_file == $0
end
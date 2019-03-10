require_relative '../DTO/LanguageDTO'

class LanguageService
	# manages languages (add/remove/update)
	# get languages based on passed params
	attr_accessor :languages
	
	def initialize
		@languages = []
		@languages.push(LanguageDTO.new(0, 'C#', true, ['if', 'await'], 'Visual Studio', 2001, 'Microsoft', true))
		@languages.push(LanguageDTO.new(1, 'Ruby', true, ['if', 'unless'], 'Notepad++', 1996, 'Yukihiro Matsumoto', false))
	end
	
	def getAllAsJson
		objectJsonArray = []
		@languages.each{ |language|
			objectJsonArray.push(language.to_json)
		}
		'[' + objectJsonArray.join(',') + ']'
	end
	
	def getMatches(releaseYear, isStronglyTyped)
		objectJsonArray = []
			
		@languages.each{ |language|
			if releaseYear != nil then
				if isStronglyTyped != nil then
					if language.release_year == releaseYear && language.strongly_typed.to_s == isStronglyTyped then
						objectJsonArray.push(language.to_json)
					end
				elsif language.release_year == releaseYear then
					objectJsonArray.push(language.to_json)
				end
			elsif language.strongly_typed.to_s == isStronglyTyped then
				objectJsonArray.push(language.to_json)
			end
		}
		'[' + objectJsonArray.join(',') + ']'
	end
	
end
require_relative '../DTO/LanguageDTO'
require_relative '../Serializers/LanguageDTOSerializer'

class LanguageService
	# manages languages (update)
	attr_accessor :languages
	attr_reader :uniqueId
	
	def initialize
		@languages = []
		@languages.push(LanguageDTO.new(1, 'C#', true, ['if', 'await'], 'Visual Studio', 2001, 'Microsoft', true))
		@languages.push(LanguageDTO.new(2, 'Ruby', true, ['if', 'unless'], 'Notepad++', 1996, 'Yukihiro Matsumoto', false))		
		@uniqueId = @languages.length
	end
	
	def getAllAsJson
		objectJsonArray = []
		@languages.each{ |language|
			objectJsonArray.push(language.to_json)
		}
		'[' + objectJsonArray.join(',') + ']'
	end
	
	def getByIdAsJson(id)
		@languages.each{ |language|
			if language.id == id then
				return language.to_json
			end
		}
		return nil
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
	
	def addLanguage(languageJson)
		if languageJson.is_a? Array then
			ids = []
			languageJson.each{ |language|
				language['id'] = @uniqueId += 1
				@languages.push(LanguageDTO.from_json(language))
				ids.push(@uniqueId)
			}
			return ids
		else
			languageJson['id'] = @uniqueId += 1
			@languages.push(LanguageDTO.from_json(languageJson))
			@uniqueId
		end
	end
	
	def removeLanguage(languageId)
		@languages.each{ |language|
			if language.id == languageId then
				@languages.delete(language)
				return true
				break
			end
		}
		false
	end
	
	def updateLanguage(languageHash)
		@languages.each_index{ |i|
			if @languages[i].id == languageHash['id'] then
				@languages[i] = LanguageDTO.from_json(languageHash)
				return true
				break
			end
		}
		false
	end
	
end
require_relative '../DTO/LanguageDTO'
require_relative '../Serializers/LanguageDTOSerializer'

require 'json'

class ValidationService

	def isPostDataValid(postDataHash)
		if postDataHash.is_a? Array then
			postDataHash.each{ |data|
				if !validateRequestJson(data) then
					return false
				end
			}
			return true
		else
			return validateRequestJson(postDataHash)
		end
	end
	
	def isPutDataValid(id, putDataHash)
		return validateRequestJson(putDataHash)
	end

	def isPatchDataValid(putDataHash)
		if putDataHash.key?('id') then
			return false
		end
			
		languageKeys = LanguageDTO.empty.to_hash
		putDataHash.each{ |key, value|
			if !languageKeys.key?(key) then
				return false
			end
		}
		true
	end
	
	def validateRequestJson(dataHash)
		dataHash['id'] = 0
		return checkTypes(dataHash)
	end
	
	def checkTypes(dataHash)
		begin
			LanguageDTOSerializer.new(LanguageDTO.from_json(dataHash)).call
			return true
		rescue
			return false
		end
	end
end

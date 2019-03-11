require_relative '../DTO/LanguageDTO'
require_relative '../Serializers/LanguageDTOSerializer'

require 'json'

class ValidationService
	#checks if POST json is valid for usage
	#checks if GET params are valid
	def isPostDataValid(postDataHash)
		if postDataHash.is_a? Array then
			postDataHash.each{ |data|
				if !validatePostJson(data) then
					return false
				end
			}
			return true
		else
			return validatePostJson(postDataHash)
		end
	end
	
	def isPutDataValid(id, putDataHash)
		if id != putDataHash['id'] then
			return false
		end
		return validatePutJson(putDataHash)
		
	end
	
	def validatePutJson(dataHash)
		languageJson = LanguageDTO.new(nil, nil, nil, nil, nil, nil, nil, nil).to_hash
		
		if dataHash.size == languageJson.size then
			languageKeys = languageJson.keys
			languageKeys.each{ |key|
				if !dataHash.has_key?(key) then
					return false
				end
			}
			return checkTypes(dataHash)
		else
			false
		end
	end
	
	def validatePostJson(dataHash)
		languageJson = LanguageDTO.new(nil, nil, nil, nil, nil, nil, nil, nil).to_hash
		
		if dataHash.size == languageJson.size-1 then
			languageKeys = languageJson.keys
			languageKeys.each{ |key|
				if key != "id" && !dataHash.has_key?(key) then
					return false
				end
			}
			dataHash['id'] = 0
			return checkTypes(dataHash)
		else
			false
		end
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
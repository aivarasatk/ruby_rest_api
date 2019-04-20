class LanguageDTO

	attr_accessor :id
	attr_accessor :language
	attr_accessor :is_object_oriented
	attr_accessor :reserved_words
	attr_accessor :popular_editor
	attr_accessor :release_year
	attr_accessor :creator
	attr_accessor :strongly_typed
	
	def initialize(id, language, is_object_oriented, reserved_words,
					popular_editor, release_year, creator, strongly_typed)
		@id = id
		@language = language
		@is_object_oriented = is_object_oriented
		@reserved_words= reserved_words
		@popular_editor= popular_editor
		@release_year= release_year
		@creator= creator
		@strongly_typed = strongly_typed
	end
	
	def to_json(*args)
	{
	  'id' => id,
	  'language' => language,
	  'is_object_oriented' => is_object_oriented,
	  'reserved_words' => reserved_words,
	  'popular_editor' => popular_editor,
	  'release_year' => release_year,
	  'creator' => creator,
	  'strongly_typed' => strongly_typed
	}.to_json(*args)
	end
	
	def to_hash
		{
		  'id' => id,
		  'language' => language,
		  'is_object_oriented' => is_object_oriented,
		  'reserved_words' => reserved_words,
		  'popular_editor' => popular_editor,
		  'release_year' => release_year,
		  'creator' => creator,
		  'strongly_typed' => strongly_typed
		}
	end

	def self.from_json(h)
	new(h['id'], h['language'], h['is_object_oriented'], h['reserved_words'],
		h['popular_editor'], h['release_year'], h['creator'], h['strongly_typed'])
	end
	
end
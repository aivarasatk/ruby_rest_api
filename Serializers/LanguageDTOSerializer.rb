require 'primalize'

class LanguageDTOSerializer < Primalize::Single
	attributes(
		id: integer,
		language: string,
		is_object_oriented: boolean,
		reserved_words: array(string),
		popular_editor: string,
		release_year: integer,
		creator: string,
		strongly_typed: boolean,
	)
end
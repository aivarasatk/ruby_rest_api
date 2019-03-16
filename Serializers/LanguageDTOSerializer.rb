require 'primalize'

class LanguageDTOSerializer < Primalize::Single
	attributes(
		id: integer,
		language: string,
		is_object_oriented: boolean,
		reserved_words: array(string),
		popular_editor: optional(string),
		release_year: optional(integer),
		creator: optional(string),
		strongly_typed: boolean,
	)
end
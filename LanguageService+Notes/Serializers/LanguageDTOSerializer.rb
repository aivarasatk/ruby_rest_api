require 'primalize'

class LanguageDTOSerializer < Primalize::Single
	attributes(
		id: integer,
		language: string,
		is_object_oriented: boolean,
		strongly_typed: boolean,
		reserved_words: optional(array(string)),
		popular_editor: optional(string),
		release_year: optional(integer),
		creator: optional(string),
		notes: optional(array(string)),
	)
end
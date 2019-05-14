package SOAP;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LanguageNotes {
    public String language;
    public boolean is_object_oriented;
    public boolean strongly_typed;
    public String[] reserved_words;
    public String popular_editor;
    public int release_year;
    public String creator;
    public int id;
    public Note []notes;
}

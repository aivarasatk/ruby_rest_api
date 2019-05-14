package SOAP;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LanguageWithNoteTitles {
    public String language;
    public boolean is_object_oriented;
    public boolean strongly_typed;
    public String[] notes;
    public String[] reserved_words;
    public String popular_editor;
    public int release_year;
    public String creator;
    public int id;

}

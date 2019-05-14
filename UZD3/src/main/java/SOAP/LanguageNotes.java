package SOAP;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LanguageNotes {
    public LanguageWithoutNoteTitles language;
    public Note []notes;
}

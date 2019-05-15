
package SOAP.jaxws;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "addLanguage", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addLanguage", namespace = "http://SOAP/")
public class AddLanguage {

    @XmlElement(required = true, name = "language", namespace = "")
    private String language;

    @XmlElement(required = true, name = "is_object_oriented", namespace = "")
    private boolean is_object_oriented;

    @XmlElement(required = true, name = "strongly_typed", namespace = "")
    private boolean strongly_typed;

    @XmlElement(name = "reserved_words", namespace = "")
    private String[] reserved_words;
    @XmlElement(name = "popular_editor", namespace = "")
    private String popular_editor;
    @XmlElement(name = "release_year", namespace = "")
    private int release_year;
    @XmlElement(name = "creator", namespace = "")
    private String creator;

    public String[] getReserved_words() {
        return reserved_words;
    }

    public void setReserved_words(String[] reserved_words) {
        this.reserved_words = reserved_words;
    }

    public String getPopular_editor() {
        return popular_editor;
    }

    public void setPopular_editor(String popular_editor) {
        this.popular_editor = popular_editor;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean getIs_object_oriented() {
        return is_object_oriented;
    }

    public void setIs_object_oriented(boolean is_object_oriented) {
        this.is_object_oriented = is_object_oriented;
    }

    public boolean getStrongly_typed() {
        return strongly_typed;
    }

    public void setStrongly_typed(boolean strongly_typed) {
        this.strongly_typed = strongly_typed;
    }
}

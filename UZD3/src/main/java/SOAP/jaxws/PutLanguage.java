
package SOAP.jaxws;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "putLanguage", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "putLanguage", namespace = "http://SOAP/")
public class PutLanguage {

    @XmlElement(required = true, name = "id", namespace = "")
    private Integer id;
    @XmlElement(name = "language", namespace = "")
    private String language;
    @XmlElement(name = "is_object_oriented", namespace = "")
    private boolean is_object_oriented;
    @XmlElement(name = "strongly_typed", namespace = "")
    private boolean strongly_typed;

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

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

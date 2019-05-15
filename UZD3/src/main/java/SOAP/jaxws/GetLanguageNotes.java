
package SOAP.jaxws;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getLanguageNotes", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLanguageNotes", namespace = "http://SOAP/")
public class GetLanguageNotes {
    @XmlElement(required = true, name = "id", namespace = "")
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

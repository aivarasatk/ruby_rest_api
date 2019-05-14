
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
    @XmlElement(required = true, name = "email", namespace = "")
    private String email;

    @XmlElement(required = true, name = "isObjectOriented", namespace = "")
    private String isObjectOriented;

    @XmlElement(required = true, name = "isStronglyTyped", namespace = "")
    private String isStronglyTyped;

    public String getIsObjectOriented() {
        return isObjectOriented;
    }

    public void setIsObjectOriented(String isObjectOriented) {
        this.isObjectOriented = isObjectOriented;
    }

    public String getIsStronglyTyped() {
        return isStronglyTyped;
    }

    public void setIsStronglyTyped(String isStronglyTyped) {
        this.isStronglyTyped = isStronglyTyped;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String name) {
        this.language = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

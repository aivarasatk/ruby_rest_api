package SOAP.jaxws;

import SOAP.LanguageWithNoteTitles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getLanguageResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLanguageResponse", namespace = "http://SOAP/")
public class GetLanguageResponse {

    @XmlElement(name = "return", namespace = "")
    private LanguageWithNoteTitles _return;

    public LanguageWithNoteTitles get_return() {
        return _return;
    }

    public void set_return(LanguageWithNoteTitles _return) {
        this._return = _return;
    }

}
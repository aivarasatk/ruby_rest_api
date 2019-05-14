
package SOAP.jaxws;

import SOAP.LanguageWithNoteTitles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getLanguagesResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLanguagesResponse", namespace = "http://SOAP/")
public class GetLanguagesResponse {

    @XmlElement(name = "return", namespace = "")
    private LanguageWithNoteTitles[] _return;

    public LanguageWithNoteTitles[] getReturn() {
        return this._return;
    }
}

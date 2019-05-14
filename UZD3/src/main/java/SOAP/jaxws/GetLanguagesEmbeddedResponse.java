
package SOAP.jaxws;

import SOAP.LanguageNotes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getLanguagesEmbeddedResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLanguagesEmbeddedResponse", namespace = "http://SOAP/")
public class GetLanguagesEmbeddedResponse {

    @XmlElement(name = "return", namespace = "")
    private LanguageNotes[] _return;
    public LanguageNotes[] getReturn() {
        return this._return;
    }

    public void setReturn(LanguageNotes[] _return) {
        this._return = _return;
    }

    public LanguageNotes[] get_return() {
        return _return;
    }

    public void set_return(LanguageNotes[] _return) {
        this._return = _return;
    }
}

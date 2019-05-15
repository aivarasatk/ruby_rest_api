
package SOAP.jaxws;

import SOAP.Note;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getLanguageNotesResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLanguageNotesResponse", namespace = "http://SOAP/")
public class GetLanguageNotesResponse {

    @XmlElement(name = "return", namespace = "")
    private Note[] _return;
    public Note[] getReturn() {
        return this._return;
    }

    public void setReturn(Note[] _return) {
        this._return = _return;
    }

    public Note[] get_return() {
        return _return;
    }

    public void set_return(Note[] _return) {
        this._return = _return;
    }
}

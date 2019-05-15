
package SOAP.jaxws;

import SOAP.returnMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "deleteLanguageNoteResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteLanguageNoteResponse", namespace = "http://SOAP/")
public class DeleteLanguageNoteResponse {

    @XmlElement(name = "return", namespace = "")
    private returnMessage _return;

    /**
     *
     * @return
     *     returns String
     */
    public returnMessage getReturn() {
        return this._return;
    }

    public returnMessage get_return() {
        return _return;
    }

    public void set_return(returnMessage _return) {
        this._return = _return;
    }

    /**
     *
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(returnMessage _return) {
        this._return = _return;
    }

}

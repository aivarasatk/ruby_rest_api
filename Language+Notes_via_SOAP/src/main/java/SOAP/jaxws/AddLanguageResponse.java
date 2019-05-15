
package SOAP.jaxws;

import SOAP.AddLanguageReturnMessage;
import SOAP.returnMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "addLanguageResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addLanguageResponse", namespace = "http://SOAP/")
public class AddLanguageResponse {

    @XmlElement(name = "return", namespace = "")
    private AddLanguageReturnMessage _return;

    /**
     *
     * @return
     *     returns String
     */
    public AddLanguageReturnMessage getReturn() {
        return this._return;
    }

    public AddLanguageReturnMessage get_return() {
        return _return;
    }

    public void set_return(AddLanguageReturnMessage _return) {
        this._return = _return;
    }

    /**
     *
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(AddLanguageReturnMessage _return) {
        this._return = _return;
    }

}

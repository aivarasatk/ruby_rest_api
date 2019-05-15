
package SOAP.jaxws;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "addLanguageNote", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addLanguageNote", namespace = "http://SOAP/")
public class AddLanguageNote {

    @XmlElement(required = true, name = "id", namespace = "")
    private Integer id;
    @XmlElement(required = true, name = "title", namespace = "")
    private String title;
    @XmlElement(required = true,name = "comment", namespace = "")
    private String comment;
    @XmlElement(required = true,name = "expiration", namespace = "")
    private String expiration;
    @XmlElement(required = true,name = "author", namespace = "")
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
}

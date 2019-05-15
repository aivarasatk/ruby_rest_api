package SOAP;

public class AddLanguageReturnMessage {
    public String message;
    public Integer[] id;
    public AddLanguageReturnMessage(){}
    public AddLanguageReturnMessage(String msg, Integer[] id){
        message = msg;
        this.id = id;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public void setId(Integer[] id) {
        this.id = id;
    }
}

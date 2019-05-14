package SOAP;

public class AddLanguageReturnMessage {
    public String message;
    public Integer[] id;
    public AddLanguageReturnMessage(){}
    public AddLanguageReturnMessage(String msg, Integer[] id){
        message = msg;
        this.id = id;
    }
}

package SOAP.endpoint;
 
import javax.xml.ws.Endpoint;
import SOAP.LanguagesImpl;
 
//Endpoint publisher
public class LanguagesPublisher {
 
	public static void main(String[] args) {

		Endpoint.publish("http://0.0.0.0:5002/languages", new LanguagesImpl());
    }
 
}
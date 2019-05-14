package SOAP;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL, parameterStyle= SOAPBinding.ParameterStyle.WRAPPED)
public interface Languages {

	@WebMethod LanguageWithNoteTitles[] getLanguages();
	@WebMethod LanguageNotes[] getLanguagesEmbedded();
	@WebMethod LanguageWithNoteTitles getLanguage(@WebParam(name="id") Integer id);
	@WebMethod Note[] getLanguageNotes( @WebParam(name="id") Integer id);

	@WebMethod AddLanguageReturnMessage addLanguage(@WebParam(name="language") String language,
										 @WebParam(name="is_object_oriented") Boolean is_object_oriented,
										 @WebParam(name="strongly_typed") Boolean strongly_typed);

	@WebMethod returnMessage addLanguageNote( @WebParam(name="id") Integer id,
											  @WebParam(name="title") String title,
											  @WebParam(name="expiration") String expiration,
											  @WebParam(name="comment") String comment,
											  @WebParam(name="author") String author);

	@WebMethod returnMessage deleteLanguage( @WebParam(name="id") Integer id);

	@WebMethod returnMessage deleteLanguageNote( @WebParam(name="id") Integer id,
												 @WebParam(name="title") String title);

	@WebMethod returnMessage putLanguage( @WebParam(name="id") Integer id,
										  @WebParam(name="language") String language,
										  @WebParam(name="is_object_oriented") Boolean is_object_oriented,
										  @WebParam(name="strongly_typed") Boolean strongly_typed);
}
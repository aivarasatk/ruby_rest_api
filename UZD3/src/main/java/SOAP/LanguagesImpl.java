package SOAP;

import javax.jws.WebService;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

//Service Implementation
@WebService(endpointInterface = "SOAP.Languages")
public class LanguagesImpl implements Languages {

    @Override
    public LanguageWithNoteTitles getLanguage(Integer id) {
        LanguageWithNoteTitles languageWithNoteTitles = null;
        try {
            URL url = new URL("http://web9969:5001/languages/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            String jsonString = JsonToObject.getJsonStringFromConnection(conn);
            languageWithNoteTitles = JsonToObject.jsonToLanguage(jsonString);
            conn.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return languageWithNoteTitles;
    }

    @Override
    public LanguageWithNoteTitles[] getLanguages() {
        LanguageWithNoteTitles[] languageWithNoteTitles = null;
        try {
            URL url = new URL("http://web9969:5001/languages");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            String jsonString = JsonToObject.getJsonStringFromConnection(conn);
            languageWithNoteTitles = JsonToObject.jsonToLanguages(jsonString);
            conn.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return languageWithNoteTitles;
    }

    public returnMessage putLanguage(Integer id, String language, Boolean is_object_oriented, Boolean strongly_typed) {
        returnMessage returnval = null;
        if (id == null) {
            throw new RuntimeException("no language ID specified");
        }
        try {
            String jsonPutString = "{";
            if (language != null)
                jsonPutString+= " \"language\" : \"" + language + "\",";

            if (is_object_oriented != null)
                jsonPutString += "\"is_object_oriented\" : " + is_object_oriented + ",";

            if (strongly_typed != null)
                jsonPutString += "\"strongly_typed\" : " + strongly_typed + ",";

            if(jsonPutString.endsWith(","))
            {
                jsonPutString = jsonPutString.substring(0,jsonPutString.length() - 1);
            }
            jsonPutString += "}";
            URL url = new URL("http://web9969:5001/languages/" + Integer.toString(id));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter out = new OutputStreamWriter(
                    conn.getOutputStream());
            out.write(jsonPutString);
            out.close();
            conn.getInputStream();
            String jsonString = JsonToObject.getJsonStringFromConnection(conn);
            returnval = JsonToObject.jsonToReturnMsg(jsonString);
            if (conn.getResponseCode() > 300) {
                throw new RuntimeException("Failed : HTTP error code from REST service was returned: "
                        + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
            returnval = new returnMessage();
            returnval.message = "error happened";
        } catch (IOException e) {
            e.printStackTrace();
            returnval = new returnMessage();
            returnval.message = "bad input";
        }
        return returnval;
    }

    @Override
    public returnMessage deleteLanguage(Integer id){
        returnMessage returnval = null;
        HttpURLConnection conn = null;
        if (id == null) {
            throw new RuntimeException("no language ID specified");
        }
        try {

            URL url = new URL("http://web9969:5001/languages/" + Integer.toString(id));
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Accept", "application/json");
            conn.connect();
            String jsonString = JsonToObject.getJsonStringFromConnection(conn);
            returnval = JsonToObject.jsonToReturnMsg(jsonString);
            if (conn.getResponseCode() == 200) {
                return new returnMessage("successfully deleted language with id " + id);
            }
            if (conn.getResponseCode() > 300) {
                throw new RuntimeException("Failed : HTTP error code from REST service was returned: "
                        + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (ProtocolException e) {
            throw new RuntimeException("Failed : Bad input");
        } catch (IOException e) {
            throw new RuntimeException("Failed : Bad input");
        }
        return returnval;
    }


    @Override
    public returnMessage deleteLanguageNote(Integer id, String title) {
        returnMessage returnval = null;
        HttpURLConnection conn = null;
        if (id == null) {
            throw new RuntimeException("no language ID specified");
        }
        if (title == null) {
            throw new RuntimeException("no language ID specified");
        }
        try {

            URL url = new URL("http://web9969:5001/languages/" + Integer.toString(id) + "/notes/" + title);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Accept", "application/json");
            conn.connect();
            String jsonString = JsonToObject.getJsonStringFromConnection(conn);
            returnval = JsonToObject.jsonToReturnMsg(jsonString);
            if (conn.getResponseCode() == 200) {
                return new returnMessage("successfully deleted language with id " + id);
            }
            if (conn.getResponseCode() > 300) {
                throw new RuntimeException("Failed : HTTP error code from REST service was returned: "
                        + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (ProtocolException e) {
            throw new RuntimeException("Failed : Bad input");
        } catch (IOException e) {
            throw new RuntimeException("Failed : Bad input");
        }
        return returnval;
    }

    @Override
    public AddLanguageReturnMessage addLanguage(String language, Boolean is_object_oriented, Boolean strongly_typed) {
        AddLanguageReturnMessage returnval = null;
        try {
            String jsonPutString = "{";
            if (language != null)
                jsonPutString+= " \"language\" : \"" + language + "\",";

            if (is_object_oriented != null)
                jsonPutString += "\"is_object_oriented\" : " + is_object_oriented.toString() + ",";

            if (strongly_typed != null)
                jsonPutString += "\"strongly_typed\" : " + strongly_typed + ",";

            if(jsonPutString.endsWith(","))
            {
                jsonPutString = jsonPutString.substring(0,jsonPutString.length() - 1);
            }
            jsonPutString += "}";
            URL url = new URL("http://web9969:5001/languages");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter out = new OutputStreamWriter(
                    conn.getOutputStream());
            out.write(jsonPutString);
            out.close();
            conn.getInputStream();
            String jsonString = JsonToObject.getJsonStringFromConnection(conn);
            returnval = JsonToObject.jsonToAddLanguageReturnMsg(jsonString);
            if (conn.getResponseCode() > 300) {
                throw new RuntimeException("Failed : HTTP error code from REST service was returned: "
                        + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
            returnval = new AddLanguageReturnMessage();
            returnval.message = "error happened";
        } catch (IOException e) {
            e.printStackTrace();
            returnval = new AddLanguageReturnMessage();
            returnval.message = "bad input";
        }
        return returnval;
    }

    @Override
    public Note[] getLanguageNotes(Integer id) {
        Note[] languageNotes = null;
        if (id == null) {
            throw new RuntimeException("no language ID specified");
        }
        try {
            URL url = new URL("http://web9969:5001/languages/" + Integer.toString(id) + "/notes");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() > 300) {
                throw new RuntimeException("Failed : HTTP error code from REST service was returned: "
                        + conn.getResponseCode());
            }
            String jsonString = JsonToObject.getJsonStringFromConnection(conn);
            languageNotes = JsonToObject.jsonToLanguageNotes(jsonString, id);
            conn.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return languageNotes;
    }

    @Override
    public returnMessage addLanguageNote(Integer id, String title, String expiration, String comment, String author) {
        returnMessage returnval = null;
        try {
            String jsonPutString = "{";
            if (title != null)
                jsonPutString+= " \"title\" : \"" + title+ "\",";

            if (expiration != null)
                jsonPutString += "\"expiration\" : \"" + expiration + "\",";

            if (comment != null)
                jsonPutString += "\"comment\" : \"" + comment + "\",";

            if (author != null)
                jsonPutString += "\"author\" : \"" + author + "\",";

            if(jsonPutString.endsWith(","))
            {
                jsonPutString = jsonPutString.substring(0,jsonPutString.length() - 1);
            }

            jsonPutString += "}";
            URL url = new URL("http://web9969:5001/languages/" + id + "/notes");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter out = new OutputStreamWriter(
                    conn.getOutputStream());
            out.write(jsonPutString);
            out.close();
            conn.getInputStream();
            String jsonString = JsonToObject.getJsonStringFromConnection(conn);
            returnval = JsonToObject.jsonToReturnMsg(jsonString);
            if (conn.getResponseCode() > 300) {
                throw new RuntimeException("Failed : HTTP error code from REST service was returned: "
                        + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
            returnval = new returnMessage("error happened");
        } catch (IOException e) {
            e.printStackTrace();
            returnval = new returnMessage("bad input");
        }
        return returnval;
    }

    @Override
    public LanguageNotes[] getLanguagesEmbedded() {
        LanguageNotes[] LanguagesNotes = null;
        try {
            URL url = new URL("http://web9969:5001/languages?embedded=notes");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() > 300) {
                throw new RuntimeException("Failed : HTTP error code from REST service was returned: "
                        + conn.getResponseCode());
            }
            String jsonString = JsonToObject.getJsonStringFromConnection(conn);
            LanguagesNotes = JsonToObject.jsonToLanguagesNotes(jsonString);
            conn.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return LanguagesNotes;
    }

}
package SOAP;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class JsonToObject {
    public static String getJsonStringFromConnection(HttpURLConnection conn ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output = "";
        String temp;
        while ((temp = br.readLine()) != null) {
            output+=temp;
        }
        br.close();
        return output;
    }

    public static LanguageWithNoteTitles[] jsonToLanguages(String jsonInString)
    {
        ObjectMapper mapper = new ObjectMapper();
        LanguageWithNoteTitles[] languageWithNoteTitles = null;
        try {
            languageWithNoteTitles = mapper.readValue(jsonInString, LanguageWithNoteTitles[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return languageWithNoteTitles;
    }


    public static LanguageWithNoteTitles jsonToLanguage(String jsonInString)
    {
        ObjectMapper mapper = new ObjectMapper();
        LanguageWithNoteTitles languageWithNoteTitles = null;
        try {
            languageWithNoteTitles = mapper.readValue(jsonInString, LanguageWithNoteTitles.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return languageWithNoteTitles;
    }
    public static returnMessage jsonToReturnMsg(String jsonInString)
    {
        ObjectMapper mapper = new ObjectMapper();
        returnMessage val = null;
        try {
            val = mapper.readValue(jsonInString, returnMessage.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return val;
    }
    public static AddLanguageReturnMessage jsonToAddLanguageReturnMsg(String jsonInString){
        ObjectMapper mapper = new ObjectMapper();
        AddLanguageReturnMessage val = null;
        try {
            val = mapper.readValue(jsonInString, AddLanguageReturnMessage.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return val;
    }


    public static Note[] jsonToLanguageNotes(String jsonInString, Integer id)
    {
        ObjectMapper mapper = new ObjectMapper();
        Note[] languageNotes = null;
        try {
            languageNotes = mapper.readValue(jsonInString, Note[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return languageNotes;
    }

    public static LanguageNotes[] jsonToLanguagesNotes(String jsonInString)
    {
        ObjectMapper mapper = new ObjectMapper();
        LanguageNotes[] languageNotes = null;
        try {
            languageNotes = mapper.readValue(jsonInString, LanguageNotes[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return languageNotes;
    }
}

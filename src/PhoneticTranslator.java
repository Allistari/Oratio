import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * PhoneticTranslator
 * Translates words into their IPA phonetic pronunciations
 * @author Eric Ke
 * Last Updated: 2018-11-21
 * Created 2018-11-20
 */

public class PhoneticTranslator {

    private static final String URL = "https://api.datamuse.com/words?sp=";
    private static final String URL2 = "&md=r&max=1";

    /**
     * Gets the IPA phonetic spelling of a word
     * @param search the word to get the pronunciation of
     * @return the pronunciation of the word
     */

    public static String getPronounce(String search) throws IOException{
        Word word;

        try {
            word = getWord(search);
            return word.getIPAPronounce();
        } catch(Exception e) {
            System.out.println("Error getting word");
            throw new IOException();
        }
    }


    private static Word getWord(String search) throws IOException {

        java.net.URL wordURL = new URL(URL + search + URL2);
        System.out.println(URL + search + URL2);
        URLConnection yc = wordURL.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        inputLine = in.readLine();

        inputLine = inputLine.substring(1,inputLine.length()-1); // the string has weird square brackets so we gotta clean it

        Gson gson = new Gson();

        return gson.fromJson(inputLine, Word.class);
    }

}

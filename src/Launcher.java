import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Launcher.java
 * main class which ties everything together
 * @author Joey Chik
 * @author Michael Tatsiopoulos
 * @author Angelina Zhang
 * @author Eric Ke
 * created 2018-11-15
 * last modified 2018-11-18
 */

public class Launcher {
    private String phoneticSpelling;
    private int preset;

    private static final String API_KEY = "ca3d251b-437c-4dea-be54-f29594e632fb";
    private static final String API_URL_1 = "https://www.dictionaryapi.com/api/v3/references/collegiate/json/";
    private static final String API_URL_2 = "?key=" + API_KEY;
    // concatenate API_URL_1 with word and then API_URL_2
    // e.g. new URL(API_URL_1 + word + API_URL_2)

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        new Launcher();
    }

    Launcher() {
        //new Display();

        //new OratioTree;

    }

    public void generatePhoneticSpelling(String word) {
        try {
            String url = API_URL_1 + word + API_URL_2;
            BufferedInputStream jsonStream = new BufferedInputStream(new URL(url).openStream());
        } catch (IOException E) {
            // handle pls
        }
    }

    public String getPhoneticSpelling() {
        return phoneticSpelling;
    }

    private class InputPanelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}

import jdk.internal.util.xml.impl.Input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
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
    private PhoneticTranslator phoneticTranslator;

    // GUI
    private OratioDisplay display;

    private String phoneticSpelling;
    private int preset;

    /**
     * main method
     * @param args idk what this actually does
     */
    public static void main(String[] args) {
        new Launcher();
    }

    private Launcher() {
        this.display = new OratioDisplay();

        // generate data structures
        // load info into data structures

        this.phoneticTranslator = new PhoneticTranslator();
    }


    /**
     * Returns the phonetic spelling.
     * @return String containing the phonetic spelling in ARPABET symbols
     */
    public String getPhoneticSpelling() {
        return phoneticSpelling;
    }



    private class InputPanelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //String word = display.getInputPanel().getTextField().getText();

            //phoneticSpelling = phoneticTranslator.getPronounciation(word);
        }
    }
}

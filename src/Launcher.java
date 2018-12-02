import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Launcher.java
 * main class which ties everything together
 * @author Joey Chik
 * @author Michael Tatsiopoulos
 * @author Angelina Zhang
 * @author Eric Ke
 * created 2018-11-15
 * last modified 2018-11-30
 */

public class Launcher {
    private final static String FILE_LOADING_ERR_MSG = "There was a problem loading the graphics.";

    private PhoneticTranslator phoneticTranslator;

    // GUI
    private OratioDisplay display;

    private String phoneticSpelling;
    private String preset;

    // data structures
    private OratioTree<MouthShape> tree;
    private OratioDEQueue<MouthShape> queue;

    /**
     * main method
     * @param args idk what this actually does
     */
    public static void main(String[] args) {
        new Launcher();
    }

    private Launcher() {
        this.display = new OratioDisplay();
        this.display.getInputPanel().getTextField().addActionListener(new InputPanelListener());

        this.preset = "test";

        // generate data structures
        try {
            String filePath = "resources\\Graphics\\" + this.preset + "\\meta.json";
            this.tree = new OratioTreeGenerator().generateTreeFromJson(filePath);
        } catch (IOException e) {
            System.err.println(FILE_LOADING_ERR_MSG);
            //System.exit(1);
        }

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
            String word = display.getInputPanel().getTextField().getText();

            phoneticSpelling = phoneticTranslator.getPronounce(word);
        }
    }
}

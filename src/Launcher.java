import java.awt.*;
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

    private String phoneticSpellings[];
    private String[] words;
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
        this.preset = "test";
        Image avatar = null;

        // generate data structures
        try {
            String filePath = "resources\\Graphics\\" + this.preset + "\\meta.json";
            OratioTreeGenerator treeGenerator = new OratioTreeGenerator();
            this.tree = treeGenerator.generateTreeFromJson(filePath);

        } catch (IOException e) {
            System.err.println(FILE_LOADING_ERR_MSG);
            //System.exit(1);
        }

        this.display = new OratioDisplay();
        this.display.getInputPanel().getTextField().addActionListener(new InputPanelListener());
        this.display.getInputPanel().getAnimateButton().addActionListener(new AnimateButtonListener());

        //this.display.get set default photo for the previewpanel

        this.phoneticTranslator = new PhoneticTranslator();
    }

    private class InputPanelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            generatePhoneticSpelling();
        }
    }

    private class AnimateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            generatePhoneticSpelling();
        }
    }

    private void generatePhoneticSpelling() {
        String phrase = display.getInputPanel().getTextField().getText();

        words = phrase.split("\\s+|\\p{Punct}+"); // splits the string at any whitespace or punctuation

        for (String s : words) {
            System.out.println(s);
        }

        phoneticSpellings = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            phoneticSpellings[i] = phoneticTranslator.getPronounce(words[i]);
        }

        display.getInputPanel().switchInputpanel(phoneticSpellings);
    }
}

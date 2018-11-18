import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

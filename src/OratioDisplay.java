import java.awt.*;
import javax.swing.JFrame;


/**
 * OratioDisplay.java
 * display class which holds all the different components
 * @author Kyle To
 * created 2018-11-20
 * last modified 2018-11-21
 */

public class OratioDisplay {

    public OratioDisplay(){
        //Create and set up the window.
        JFrame frame = new JFrame("Oratio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void addComponentsToPane(Container pane) {

        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        GalleryPanel GalleryPanel = new GalleryPanel(pane, c);

        PreviewPanel PreviewPanel = new PreviewPanel(pane,c);

        InputPanel InputPanel = new InputPanel(pane, c);

    }

    public static void main(String[] args) { //to test display
        //createAndShowGUI();
        OratioDisplay display = new OratioDisplay();
    }

}
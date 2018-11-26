import jdk.internal.util.xml.impl.Input;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


/**
 * OratioDisplay.java
 * display class which holds all the different components
 * @author Kyle To
 * created 2018-11-20
 * last modified 2018-11-21
 */

public class OratioDisplay {
    private GalleryPanel galleryPanel;
    private PreviewPanel previewPanel;
    private InputPanel inputPanel;

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

    private void addComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        galleryPanel = new GalleryPanel(pane, c);
        previewPanel = new PreviewPanel(pane,c);
        inputPanel = new InputPanel(c);

        pane.add(inputPanel, c);
    }

    public InputPanel getInputPanel() {
        return inputPanel;
    }

    public static void main(String[] args) { //to test display
        //createAndShowGUI();
        OratioDisplay display = new OratioDisplay();
    }

}
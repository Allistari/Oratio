//import jdk.internal.util.xml.impl.Input;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


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
    private TitledBorder title;

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
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.05;   //request extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.gridx = 0;       //1st column
        c.gridy = 2;       //third row
        c.gridwidth = 3;   //3 columns wide
        c.gridheight = 1;  //1 row tall
        title = BorderFactory.createTitledBorder("Input"); //creates titled border
        inputPanel.setBorder(title);

        pane.add(inputPanel, c);
    }

    public InputPanel getInputPanel() {
        return inputPanel;
    }

    public void animate(){

    }

    public static void main(String[] args) { //to test display
        //createAndShowGUI();
        OratioDisplay display = new OratioDisplay();
    }

}
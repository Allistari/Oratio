import java.awt.*;
import java.awt.MenuBar;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * OratioDisplay.java
 * display class which holds all the different components
 * @author Kyle To
 * @author Angelina
 * created 2018-11-20
 * last modified 2018-11-21
 */

public class OratioDisplay extends JFrame{
    private GalleryPanel galleryPanel;
    private PreviewPanel previewPanel;
    private InputPanel inputPanel;
    private TitledBorder title;
    private OratioMenuBar oratioMenu;
    // Constructor
    public OratioDisplay(){
        // Create and set up the window.
        JFrame frame = new JFrame("Oratio");
        frame.setSize(2000,1500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oratioMenu = new OratioMenuBar();
        addComponentsToPane(frame.getContentPane());
        frame.setJMenuBar(oratioMenu);
        // Display the window.
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public OratioMenuBar getOratioMenuBar(){
        return this.oratioMenu;
    }
    public void setOratioMenuBar(OratioMenuBar menuBar){
        this.oratioMenu = menuBar;
    }

    // Method for adding components to the pane
    private void addComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        pane.setSize(500,300);
        galleryPanel = new GalleryPanel(pane, c);
        galleryPanel.setSize(300,100);
        previewPanel = new PreviewPanel(pane,c);
        previewPanel.setSize(200,300);
        inputPanel = new InputPanel(c); // created here to be used in launcher class
        inputPanel.setSize(400,100);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.05;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.gridheight = 1;

        title = BorderFactory.createTitledBorder("Input"); // creates titled border
        inputPanel.setBorder(title);
        pane.add(inputPanel, c);
    }

    // Method for getting the input panel
    public InputPanel getInputPanel() {
        return inputPanel;
    }

    // getter for preview panel
    public PreviewPanel getPreviewPanel() {
        return previewPanel;
    }
}

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

public class OratioDisplay extends JPanel{
    private GalleryPanel galleryPanel;
    private PreviewPanel previewPanel;
    private InputPanel inputPanel;
    private TitledBorder title;
    private Launcher launcher;

    // Constructor
    public OratioDisplay(Launcher launcher){
        this.launcher = launcher;

        // Create and set up the window.
        JFrame frame = new JFrame("Oratio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the content pane.
        addComponentsToPane(this);

        // Display the window.
        frame.add(this);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Method for adding components to the pane
    private void addComponentsToPane(OratioDisplay display) {
        display.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        galleryPanel = new GalleryPanel(display, c);

        previewPanel = new PreviewPanel(display,c);

        inputPanel = new InputPanel(display, c); // created here to be used in launcher class
    }

    // getter for launcher
    public Launcher getLauncher() {
        return launcher;
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

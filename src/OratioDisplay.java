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
 * last modified 2018-12-07
 */

public class OratioDisplay extends JFrame{
    private GalleryPanel galleryPanel;
    private PreviewPanel previewPanel;
    private InputPanel inputPanel;
    private TitledBorder title;
    private Launcher launcher;
    private OratioMenuBar oratioMenu;
    private JPanel contentPane;

    // Constructor
    public OratioDisplay(Launcher launcher){
        super("Oratio");
        this.launcher = launcher;
        contentPane = new JPanel(new GridBagLayout());

        // Create and set up the window.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        oratioMenu = new OratioMenuBar();
        this.setJMenuBar(oratioMenu);

        this.setContentPane(contentPane);
        addComponentsToPane(this);

        // Display the window.
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public OratioMenuBar getOratioMenuBar(){
        return this.oratioMenu;
    }
    public void setOratioMenuBar(OratioMenuBar menuBar){
        this.oratioMenu = menuBar;
    }

    // Method for adding components to the pane
    private void addComponentsToPane(OratioDisplay display) {
        GridBagConstraints c = new GridBagConstraints();

        galleryPanel = new GalleryPanel(display, c);

        previewPanel = new PreviewPanel(display,c);
        inputPanel = new InputPanel(display, c);

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

    // getter for preview panel
    public GalleryPanel getGalleryPanel() {
        return galleryPanel;
    }
}

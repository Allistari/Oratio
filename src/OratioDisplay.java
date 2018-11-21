import javax.swing.*;
import java.awt.*;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;

public class OratioDisplay {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        JButton button;
        JTextField textField;
        JPanel previewPanel;
        JPanel galleryPanel;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        galleryPanel = new JPanel();
        //button = new JButton("Gallery Panel");
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.FIRST_LINE_END; //top of space
        c.gridx = 2;       //aligned with button 1
        c.gridwidth = 1;   //2 columns wide
        c.gridheight = 2;
        c.gridy = 0;       //first row
        galleryPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        pane.add(galleryPanel, c);
        //pane.add(button,c);

        previewPanel = new JPanel();
        //button = new JButton("Preview Panel");
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //top of space
        c.insets = new Insets(0,0,10,0);  //top padding
        c.gridx = 0;       //aligned with button 1
        c.gridwidth = 2;   //2 columns wide
        c.gridheight = 2;
        c.gridy = 0;       //first row
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Preview");
        previewPanel.setBorder(title);
        pane.add(previewPanel, c);
        //pane.add(button,c);


        textField = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weightx = 1.0;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 0;       //aligned with button 1
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;       //third row
        pane.add(textField, c);

        button = new JButton("Animate");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weightx = 0.5;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 2;       //aligned with button 3
        c.gridwidth = 1;   //1 columns wide
        c.gridy = 2;       //third row
        pane.add(button, c);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
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

    public static void main(String[] args) {
        createAndShowGUI();
    }

}
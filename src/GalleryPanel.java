import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * GalleryPanel.java
 * gallery panel class which holds all the components in the gallery panel
 * @author Kyle To
 * created 2018-11-20
 * last modified 2018-11-21
 */

public class GalleryPanel extends JPanel{
    JPanel panel;
    TitledBorder title;
    GridBagConstraints c;
    OratioDEQueue<MouthShape> queue;

    // Constructor
    public GalleryPanel(Container pane, GridBagConstraints constraints){
        panel = new JPanel();
        c = constraints;

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.gridy = 0;
        title = BorderFactory.createTitledBorder("Gallery");
        panel.setBorder(title);
        pane.add(panel, c);
    }

    // Get method
    public JPanel get(){
        return this.panel;
    }

    // Method that sets the queue for mouth shapes
    public void setQueue(OratioDEQueue<MouthShape> queue) {
        this.queue = queue;
    }

    // Method for displaying the frames needed for animation
    public void showFrames(){
        while (!queue.isEmpty()){

        }
    }
}

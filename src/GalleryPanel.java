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
    TitledBorder title;
    GridBagConstraints c;
    OratioDEQueue<MouthShape> queue;
    private OratioDisplay display;

    // Constructor
    public GalleryPanel(OratioDisplay display, GridBagConstraints constraints){
        super();
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
        this.setBorder(title);
        display.getContentPane().add(this, c);
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

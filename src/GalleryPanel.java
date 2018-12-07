import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

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
    MouthShape current;
    JLabel show;
    ImageIcon icon;
    Image temp;

    // Constructor
    public GalleryPanel(OratioDisplay display, GridBagConstraints constraints){
        super(new GridLayout(0,2));
        c = constraints;

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0;
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
        for (int i = 0; i < queue.size(); i++) {
            current = queue.pollFirst();
            temp = current.getImage();
            Image newimg = temp.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            icon = new ImageIcon(newimg);
            show = new JLabel(icon);
            this.add(show);
            queue.addLast(current);
        }
    }

}

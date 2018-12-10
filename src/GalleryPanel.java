import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

/**
 * GalleryPanel.java
 * gallery panel class which holds all the components in the gallery panel
 * @author Kyle To
 * created 2018-11-20
 * last modified 2018-11-21
 */

public class GalleryPanel extends JPanel{
    private TitledBorder title;
    private GridBagConstraints c;
    private OratioDEQueue<MouthShape> queue;
    private MouthShape current;
    private JLabel show;
    private ImageIcon icon;
    private Image temp;

    // Constructor
    public GalleryPanel(OratioDisplay display, GridBagConstraints constraints){
        super(new GridLayout(0,1));
        c = constraints;

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.75;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.gridy = 0;
        title = BorderFactory.createTitledBorder("Gallery"); //creates titled border
        this.setBorder(title);
        JScrollPane panelPane = new JScrollPane(this);
        panelPane.setBorder(createEmptyBorder());
        display.getContentPane().add(panelPane, c);
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
            Image newImg = temp.getScaledInstance(254, 325,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            icon = new ImageIcon(newImg);
            show = new JLabel(icon);
            this.add(show);
            queue.addLast(current);
        }
    }

}

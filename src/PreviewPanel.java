import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * PreviewPanel.java
 * preview panel class which holds all the components in the preview panel
 * @author Kyle To
 * @author Michael Tatsiopoulos
 * created 2018-11-20
 * last modified 2018-11-21
 */

public class PreviewPanel extends JPanel{
    JPanel panel;
    TitledBorder title;
    GridBagConstraints c;
    OratioDEQueue<MouthShape> queue;
    BufferedImage avatar;
    int position;
    MouthShape current;

    // Constructor
    public PreviewPanel(Container pane, GridBagConstraints constraints){
        panel = new JPanel(new GridLayout()); // grid layout used to keep image within panel
        c = constraints;

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridheight = 2;
        c.gridy = 0;
        title = BorderFactory.createTitledBorder("Preview");
        panel.setBorder(title);
        position = 0;

        // Gets image from file
        try {
            avatar = ImageIO.read(new File("resources/MouthShapes/avatar.jpg"));
        } catch (IOException ex) {
            System.out.println("Warning: IO Exception");
        }

        // Sets initial image as the avatar chosen
        JLabel start = new JLabel(new ImageIcon(avatar));
        panel.add(start);

        pane.add(panel, c);
    }

    public void animate(){
        do{
            queue.addLast(current);
            position++;
            position = position % queue.size();
            avatar = (BufferedImage)current.getImage();
        }while (position > 0);
    }

    public JPanel get(){
        return this.panel;
    }

    // Set the queue for mouth shapes
    public void setQueue(OratioDEQueue<MouthShape> queue) {
        this.queue = queue;
        this.current = queue.pollFirst();
    }

}

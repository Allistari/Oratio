import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * PreviewPanel.java
 * preview panel class which holds all the components in the preview panel
 * @author Kyle To
 * @author Michael Tatsiopoulos
 * @author Angelina
 * created 2018-11-20
 * last modified 2018-12-07
 */

public class PreviewPanel extends JPanel{
    OratioDisplay display;
    TitledBorder title;
    GridBagConstraints c;
    JLabel imageLabel;
    OratioDEQueue<MouthShape> queue;
    MouthShape avatar;
    int position;
    MouthShape current;
    Image currentFrame;
    DrawPanel drawingPanel;

    // Constructor
    public PreviewPanel(OratioDisplay display, GridBagConstraints constraints){
        super(new GridLayout());
        this.display = display;
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
        this.setBorder(title);
        position = 0;
        drawingPanel = new DrawPanel();

        // Sets initial image as the avatar chosen
        imageLabel = new JLabel();
        this.add(imageLabel);
        display.getContentPane().add(this, c);
    }

    public class DrawPanel extends JPanel{
        public void paintComponent(Graphics g){
            g.drawImage(currentFrame,0,0,this);
        }
    }

    public void makeAnimation(){
        while(true){
            current = queue.pollFirst();
            currentFrame = current.getImage();
            try{
                Thread.sleep(50);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            display.repaint();
            queue.addLast(current);

        }
    }

    // Set the queue for mouth shapes
    public void setQueue(OratioDEQueue<MouthShape> queue) {
        this.queue = queue;
        this.current = queue.pollFirst();
    }

    public void setAvatar(MouthShape avatar) {
        this.avatar = avatar;
        imageLabel.setIcon(new ImageIcon(avatar.getFileName()));
    }
}

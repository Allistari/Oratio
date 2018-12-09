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
    OratioDEQueue<MouthShape> queue = new OratioDEQueue<>();
    MouthShape avatar;
    int position;
    MouthShape current;
    ImageIcon currentFrame;
    JLabel animatedImage;
    private OratioTree<MouthShape> tree;

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
        System.out.println(queue.size());

        imageLabel = new JLabel();
        if (queue.size() ==0)
            imageLabel.setIcon(new ImageIcon("resources\\Graphics\\default\\avatar.jpg"));
       else
           imageLabel.setIcon(currentFrame);

        this.add(imageLabel);

        display.getContentPane().add(this, c);
    }



//    public void animateImage(ImageIcon currentFrame){
//            imageLabel.setIcon(currentFrame);
//            this.validate();
//            this.repaint();
//         }
public void makeAnimation(){
    System.out.println(queue.size());
    while(queue.size()>0){
        MouthShape current = queue.pollFirst();
        System.out.println(current.getFileName());
        ImageIcon currentFrame = current.getImageIcon();
        this.currentFrame = currentFrame;
        try{
            Thread.sleep(100);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        this.repaint();

        queue.addLast(current);
    }
}
    // Set the queue for mouth shapes
    public void setQueue(OratioDEQueue<MouthShape> queue) {
        this.queue = queue;
        //this.current = queue.pollFirst();
    }
    public OratioDEQueue getQueue (){
        return this.queue;
    }

//    public void setAvatar(MouthShape avatar) {
//        this.avatar = avatar;
//        imageLabel.setIcon(new ImageIcon(avatar.getFileName()));
//    }
}

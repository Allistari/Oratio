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

public class PreviewPanel extends JPanel {
    OratioDisplay display;
    TitledBorder title;
    GridBagConstraints c;
    JLabel imageLabel;
    OratioDEQueue<MouthShape> queue = new OratioDEQueue<>();
    MouthShape current;
    BufferedImage currentFrame;


    // Constructor
    public PreviewPanel(OratioDisplay display, GridBagConstraints constraints) {
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
        imageLabel = new JLabel();
        if (queue.size() == 0) {
            imageLabel.setIcon(new ImageIcon("resources\\Graphics\\default\\avatar.jpg"));
        }
        this.add(imageLabel);
        display.getContentPane().add(this, c);
    }

    // Set the queue for mouth shapes
    public void setQueue(OratioDEQueue<MouthShape> queue) {
        this.queue = queue;
    }

    public OratioDEQueue getQueue() {
        return this.queue;
    }

    public void animate(OratioDEQueue queue) {
        int i = 1;
        String outputPath = "output\\" + i + ".gif";
        try {
            AnimatedGifEncoder encoder = new AnimatedGifEncoder();
            encoder.start(outputPath);
            encoder.setDelay(500);
            encoder.setRepeat(0);
            for (int j = 0; j < queue.size(); j++) {
                current = (MouthShape) queue.pollFirst();
                currentFrame = ImageIO.read(new File(current.getFileName()));
                encoder.addFrame(currentFrame);
                System.out.println(current.getFileName());
            }
            encoder.finish();
            i++;
            imageLabel.setIcon(new ImageIcon(outputPath));
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }
    }
}

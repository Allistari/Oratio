import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * GalleryPanel.java
 * gallery panel class which holds all the components in the gallery panel
 * @author Joey Chik
 * @author Michael Tatsiopoulos
 * @author Angelina Zhang
 * @author Eric Ke
 * @author Kyle To
 * created 2018-11-20
 * last modified 2018-11-21
 */

public class GalleryPanel extends JPanel{
    JPanel panel;
    TitledBorder title;
    GridBagConstraints c;

    public GalleryPanel(Container pane, GridBagConstraints constraints){
        panel = new JPanel();
        c = constraints;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.FIRST_LINE_END; //top of space
        c.gridx = 2;       //aligned with button 1
        c.gridwidth = 1;   //2 columns wide
        c.gridheight = 2;
        c.gridy = 0;       //first row
        title = BorderFactory.createTitledBorder("Preview");
        panel.setBorder(title);
        pane.add(panel, c);
    }

    public JPanel get(){
        return this.panel;
    }
}

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * PreviewPanel.java
 * preview panel class which holds all the components in the preview panel
 * @author Joey Chik
 * @author Michael Tatsiopoulos
 * @author Angelina Zhang
 * @author Eric Ke
 * @author Kyle To
 * created 2018-11-20
 * last modified 2018-11-21
 */

public class PreviewPanel extends JPanel{
    JPanel panel;
    TitledBorder title;
    GridBagConstraints c;

    public PreviewPanel(Container pane, GridBagConstraints constraints){
        panel = new JPanel();
        c = constraints;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //top of space
        c.gridx = 0;       //aligned with button 1
        c.gridwidth = 2;   //2 columns wide
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
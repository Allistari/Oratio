import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * InputPanel.java
 * input panel class which holds all the components in the input panel
 * @author Joey Chik
 * @author Michael Tatsiopoulos
 * @author Angelina Zhang
 * @author Eric Ke
 * @author Kyle To
 * created 2018-11-20
 * last modified 2018-11-21
 */

public class InputPanel extends JPanel{
    JPanel panel;
    TitledBorder title;
    GridBagConstraints c;
    JButton animateButton;
    JTextField textField;

    public InputPanel(Container pane, GridBagConstraints constraints){
        JPanel panel = new JPanel(new GridBagLayout());
        c = constraints;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //top of space
        c.gridx = 0;       //aligned with button 1
        c.gridwidth = 3;   //3 columns wide
        c.gridheight = 1;
        c.gridy = 2;       //third row
        title = BorderFactory.createTitledBorder("Input");
        panel.setBorder(title);
        pane.add(panel, c);

        animateButton = new JButton("Animate");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weightx = 0.5;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.gridx = 2;       //aligned with button 3
        c.gridwidth = 1;   //1 columns wide
        c.gridy = 1;       //third row
        panel.add(animateButton, c);

        textField = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weightx = 1.0;
        c.weighty = 0.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.gridx = 0;       //aligned with button 1
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 1;       //third row
        panel.add(textField, c);
    }

    public JPanel get(){
        return this.panel;
    }
}
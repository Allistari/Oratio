import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    JLabel spelling;
    JButton reAnimateButton;
    JButton resetButton;
    String text;

    public InputPanel(Container pane, GridBagConstraints constraints){
        c = constraints;

        JPanel panel = new JPanel(new GridBagLayout());
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.05;   //request extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.gridx = 0;       //1st column
        c.gridy = 2;       //third row
        c.gridwidth = 3;   //3 columns wide
        c.gridheight = 1;  //1 row tall
        title = BorderFactory.createTitledBorder("Input"); //creates titled border
        panel.setBorder(title);
        pane.add(panel, c);

        //Creates initial animate button
        animateButton = createAnimateButton(panel);
        panel.add(animateButton, c);

        //Creates initial text field
        textField = createTextField(panel);
        panel.add(textField, c);
    }

    public JLabel createTextLabel(JPanel panel){
        spelling = new JLabel();
        c.weightx = 1.0;   //requests extra horizontal space
        c.weighty = 0.0;
        c.anchor = GridBagConstraints.LINE_START; //left of space
        c.gridx = 0;       //1st column
        c.gridy = 0;
        c.gridwidth = 1;   //1 column wide
        return spelling;
    }

    public JButton createAnimateButton(JPanel panel){
        animateButton = new JButton("Animate");
        c.weightx = 0.5;   //requests extra horizontal space
        c.weighty = 0.0;
        c.anchor = GridBagConstraints.LINE_END; //right of space
        c.gridx = 2;       //3rd column
        c.gridy = 0;
        c.gridwidth = 1;   //1 columns wide
        animateButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                    text = textField.getText();
                    panel.remove(textField);
                    spelling = createTextLabel(panel);
                    spelling.setText(text);
                    panel.add(spelling);
                    panel.remove(animateButton);
                    reAnimateButton = createReAnimateButton(panel);
                    panel.add(reAnimateButton,c);
                    resetButton = createResetButton(panel);
                    panel.add(resetButton, c);
                    panel.validate();
                    panel.repaint();
            }
        });
        return animateButton;
    }

    public JTextField createTextField(JPanel panel){
        textField = new JTextField();
        c.weightx = 1.0;   //request extra horizontal space
        c.anchor = GridBagConstraints.LINE_START; //left of space
        c.gridx = 0;       //1st column
        c.gridy = 0;
        c.gridwidth = 2;   //2 columns wide
        return textField;
    }

    public JButton createReAnimateButton(JPanel panel){
        reAnimateButton = new JButton("ReAnimate");
        c.weightx = 0.5;   //request extra horizontal space
        c.weighty = 0.0;
        c.anchor = GridBagConstraints.CENTER; //center of space
        c.gridx = 1;       //2nd column
        c.gridy = 0;
        c.gridwidth = 1;   //1 columns wide
        return reAnimateButton;
    }

    public JButton createResetButton(JPanel panel){
        resetButton = new JButton("Reset");
        c.weightx = 0.5;   //request extra horizontal space
        c.weighty = 0.0;
        c.anchor = GridBagConstraints.LINE_END; //right of space
        c.gridx = 2;       //3rd column
        c.gridy = 0;
        c.gridwidth = 1;   //1 columns wide

        resetButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                panel.remove(spelling);
                panel.remove(reAnimateButton);
                panel.remove(resetButton);
                textField = createTextField(panel);
                panel.add(textField,c);
                animateButton = createAnimateButton(panel);
                panel.add(animateButton, c);
                panel.validate();
                panel.repaint();
            }
        });
        return resetButton;
    }

    public JPanel get(){
        return this.panel;
    }

}
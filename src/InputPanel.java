import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * InputPanel.java
 * input panel class which holds all the components in the input panel
 * @author Kyle To
 * created 2018-11-20
 * last modified 2018-11-21
 */

public class InputPanel extends JPanel{
    private TitledBorder title;
    private GridBagConstraints c;
    private JButton animateButton;
    private JTextField textField;
    private JLabel output;
    private JButton reAnimateButton;
    private JButton resetButton;
    private String text;
    private PhoneticTranslator phoneticTranslator;
    private String phoneticSpelling;
    private String[] splitText;

    // Constructor
    public InputPanel(GridBagConstraints constraints){
        super(new GridBagLayout());
        c = constraints;
        phoneticTranslator = new PhoneticTranslator();

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.05;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.gridheight = 1;
        title = BorderFactory.createTitledBorder("Input"); //creates titled border
        this.setBorder(title);

        // Creates initial animate button
        animateButton = createAnimateButton(this);
        this.add(animateButton, c);

        // Creates initial text field
        textField = createTextField(this);
        this.add(textField, c);
    }

    // Method for creating the text label for output
    private JLabel createTextLabel(JPanel panel){
        output = new JLabel();
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        return output;
    }

    private JButton createAnimateButton(JPanel panel){
        animateButton = new JButton("Animate");
        c.weightx = 0.5;
        c.weighty = 0.0;
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        animateButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                    text = textField.getText();
                    panel.remove(textField);

                    // Splits inputted text into words
                    splitText = text.split("\\s+");

                    // Translates the split words into their phonetic spelling and recombines them into one string
                    phoneticSpelling = "";
                    String temp;
                    for (int i = 0; i < splitText.length; i++){
                        temp = phoneticTranslator.getPronounce(splitText[i]);
                        phoneticSpelling = phoneticSpelling + " " + temp;
                    }

                    // Creates text label with both input and phonetic spelling
                    output = createTextLabel(panel);
                    output.setText(text + " " + phoneticSpelling + "  ");
                    panel.add(output);

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

    private JTextField createTextField(JPanel panel){
        textField = new JTextField();
        c.weightx = 1.0;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        return textField;
    }

    private JButton createReAnimateButton(JPanel panel){
        reAnimateButton = new JButton("Reanimate");
        c.weightx = 0.5;
        c.weighty = 0.0;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        return reAnimateButton;
    }

    private JButton createResetButton(JPanel panel){
        resetButton = new JButton("Reset");
        c.weightx = 0.5;
        c.weighty = 0.0;
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;

        resetButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                panel.remove(output);
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

    public JTextField getTextField() {
        return textField;
    }
}

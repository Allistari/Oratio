import javax.swing.*;
import java.awt.*;

public class OratioDisplay extends JFrame {
    private JLabel label;
    private JButton button;
    private JPanel panel;
    private JTextField textBox;
    public OratioDisplay() {
        super("Oratio");
        setLayout(new BorderLayout());
        label = new JLabel("Enter word/phrase");
        //label.setBounds(800,0,500,100);
        add(label);
        button = new JButton("Animate!");
        //button.setBounds(300, 500, 100, 50);
        //button.setPreferredSize(new Dimension(500, 100));
        add(button, BorderLayout.EAST);
        textBox = new JTextField("", 20);
        add(textBox);
        //frame.add(panel);
        //setSize(500, 500);
       // panel.add(button);

    }

    public static void main(String[] args) {

        new OratioDisplay();
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GraphicsSetCreator extends JFrame{
    private static final String FILE_NAME_TAKEN_MSG = "This file name is already taken. Try another one.";

    private JPanel mainPanel;
    private JButton mouthShapeAddButton;
    private JTextArea mouthShapePhoneticDisplayTextArea;
    private JTextField mouthShapePhoneticTextField;
    private JTextField mouthShapeFileNameTextField;

    private GraphicsSetCreator() {
        super("Graphics Set Creator");

        this.add(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] args) {
        new GraphicsSetCreator();
    }

    private class MouthShapePanel extends JPanel {
        private JPanel mainPanel;
        private JTextArea phoneticDisplayArea;
        private JTextField phoneticInputTextField;
        private JTextField fileNameTextField;
        private JButton addButton;

        MouthShapePanel() {
            super();
            this.add(this.mainPanel);

            this.phoneticInputTextField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = phoneticInputTextField.getText();
                    phoneticDisplayArea.setText(phoneticDisplayArea.getText() + text + '\n');
                }
            });
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    File metadata;

                    try {
                        String fileName = fileNameTextField.getText();
                        if (!Files.exists(Paths.get("Graphics/" + fileName))) {
                            metadata = new File("Graphics/" + fileName);
                        } else {
                            JOptionPane.showMessageDialog(mainPanel, FILE_NAME_TAKEN_MSG);
                            return;
                        }
                    } catch (SecurityException f) {
                        System.err.println("This is a SecurityException and I don't know what it is");
                        System.exit(1);
                    }


                }
            });
        }
    }
}

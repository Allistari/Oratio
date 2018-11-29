import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GraphicsSetCreator extends JFrame{
    private static final String FILE_NAME_TAKEN_MSG = "This file name is already taken. Try another one.";
    private static final String FILE_IO_EXCEPTION_MSG = "There was an error creating the file.";
    private static final String IMG_FILE_IO_EXCEPTION_MSG = "There was an error moving the image file.";
    private static final String FILE_WRITING_EXCEPTION_MSG = "There was an error writing to the file.";

    private JPanel mainPanel;
    private JButton createDirectoryButton;
    private MouthShapePanel mouthShapePanel;
    private JTextField graphicsSetNameTextField;
    private JButton mouthShapeAddButton;
    private JTextArea mouthShapePhoneticDisplayTextArea;
    private JTextField mouthShapePhoneticTextField;
    private JTextField mouthShapeFileNameTextField;

    private OratioLinkedList<MouthShape> mList;
    private File directory;
    private String graphicsSetName;

    private GraphicsSetCreator() {
        super("Graphics Set Creator");

        this.mList = new OratioLinkedList<>();

        this.add(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();

        graphicsSetName = JOptionPane.showInputDialog("What would you like to name your graphics set?");

        this.directory = new File("resources\\Graphics\\" + graphicsSetName);
        //if (this.directory.exists()) System.out.println("THIS FINALLY FUCKING WORKS HOLY FUCK");

        createDirectoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                directory.mkdir();
                System.out.println(directory.getAbsolutePath());

                for (int i = 0; i < mList.size(); i++) {
                    MouthShape m = mList.get(i);

                    m.setFileName(directory.getAbsolutePath() + m.getFileName());
                }

                createMetadataJson(directory);
            }
        });
    }

    public static void main(String[] args) {
        new GraphicsSetCreator();
    }

    private void createMetadataJson(File directory) {
        File metadata = new File(directory.getPath() + "\\meta.json");

        try {
            if (!metadata.createNewFile()) {
                JOptionPane.showMessageDialog(mainPanel, FILE_NAME_TAKEN_MSG);
            }
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(mainPanel, FILE_IO_EXCEPTION_MSG);
            return;
        } catch (SecurityException exception) {
            System.err.println("this is a SecurityException and i don't know what it is");
            System.exit(1);
        }

        try {
            new JsonGenerator().generateJSON(mList, metadata);
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(mainPanel, FILE_WRITING_EXCEPTION_MSG);
        }
    }

    private void createUIComponents() {
        mouthShapePanel = new MouthShapePanel();
    }

    private class MouthShapePanel extends JPanel {
        private JPanel mainPanel;
        private JTextArea phoneticDisplayArea;
        private JTextField phoneticInputTextField;
        private JTextField fileNameTextField;
        private JButton addButton;
        private JButton chooseFileButton;
        private JPanel filePanel;

        private OratioLinkedList<String> phoneticList;

        MouthShapePanel() {
            super();
            this.add(this.mainPanel);

            this.phoneticList = new OratioLinkedList<>();

            this.phoneticInputTextField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = phoneticInputTextField.getText();
                    text = text.trim();
                    //make sure white space isnt added to the list
                    if (text.length() <= 0) return;
                    phoneticList.add(text);
                    phoneticInputTextField.setText("");
                    phoneticDisplayArea.setText(phoneticDisplayArea.getText() + text + '\n');
                }
            });
            this.addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String fileName = fileNameTextField.getText();
                    String[] phoneticArray = phoneticList.toArray();

                    // move image from original location to resources root
                    File imgFile = new File(fileName);

                    /*
                    File newLocation = new File(directory, imgFile.getName());
                    System.out.println(imgFile.toPath() + "\n" + newLocation.getAbsolutePath());
                    if (!imgFile.renameTo(newLocation)) {
                        JOptionPane.showMessageDialog(mainPanel, IMG_FILE_IO_EXCEPTION_MSG);
                        return;
                    }
                    */

                    MouthShape m = new MouthShape(imgFile.getName(), phoneticArray);

                    mList.add(m);

                    fileNameTextField.setText("");
                    phoneticInputTextField.setText("");
                    phoneticDisplayArea.setText("");
                }
            });
            this.chooseFileButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                    FileNameExtensionFilter filter = new FileNameExtensionFilter(
                            "Image files",
                            "jpg", "jpeg", "png", "bmp", "gif"
                    );
                    fileChooser.setFileFilter(filter);

                    int returnState = fileChooser.showOpenDialog(mainPanel);

                    if (returnState == JFileChooser.APPROVE_OPTION) {
                        fileNameTextField.setText(fileChooser.getSelectedFile().getPath());
                    }
                }
            });
        }
    }
}

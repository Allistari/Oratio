import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.io.File;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * OratioMenuBar.java
 * Creates a Menu bar
 * @author Angelina
 * created 2018-11-29
 * last modified 2018-12-05
 */

public class OratioMenuBar extends JMenuBar { //implements ActionListener, KeyListener{
    OratioLinkedList<String> pNames = new OratioLinkedList<String>();
    String presetName;
    public OratioMenuBar() {
        createMenuBar();
    }
    private void createMenuBar(){
        OratioLinkedList<File> presetNames = new OratioLinkedList<File>();
        File presetFile = new File("resources\\Graphics");
        getPresetName(presetFile,presetNames);
        if(presetNames.size()>0){

            String name;
            for(int i = 0; i <presetNames.size();i++){
                name = presetNames.get(i).toString();
                pNames.add(name.substring(name.lastIndexOf("\\")+1));
            }
        }

        //JMenuBar menuBar = new JMenuBar();
        JMenu helpMenu = new JMenu("Help");
        JMenuItem about = new JMenuItem("About Oratio");
        about.setToolTipText("About");
        about.setMnemonic(KeyEvent.VK_TAB);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popUp();
            }
        });
        JMenu presetMenu = new JMenu("Presets");
        presetMenu.setMnemonic(KeyEvent.VK_TAB);
        for (int i = 0; i<pNames.size();i++) {
            String names = pNames.get(i);
            JMenuItem item = new JMenuItem(names);
            item.setMnemonic(KeyEvent.VK_DOWN);
            item.setToolTipText(names+" Preset");
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = item.getText();
                    setPresetName(name);
                }
            });
            presetMenu.add(item);
            helpMenu.add(about);
            add(presetMenu);
            add(helpMenu);
            //menuBar.revalidate();
        }
    }

    public void setPresetName(String name){
        this.presetName = name;
    }
    public String getPresetName (){
        return this.presetName;
    }
    private void popUp(){
        JFrame dialogWindow = new JFrame("About Oratio");
        dialogWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialogWindow.setSize(300,400);
        JOptionPane.showMessageDialog(dialogWindow, "Oratio draws mouth shape animations ^^");

    }

    private void getPresetName(File file, OratioLinkedList<File> Folders){
        if(file.isDirectory()){

            File[] path = file.listFiles();

            for (File f : path) {
                if(f.isDirectory()){
                    Folders.add(f);
                }

            }
        }
    }
}


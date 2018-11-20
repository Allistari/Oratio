import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        OratioDisplay oratio = new OratioDisplay();
        oratio.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        oratio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oratio.setVisible(true);
    }
}

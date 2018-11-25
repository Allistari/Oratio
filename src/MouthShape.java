import javax.swing.*;
import java.awt.Image;

public class MouthShape {
    String [] spelling;
    String fileName;
    ImageIcon image;

    public MouthShape(String fileName, String[] spelling){
        this.fileName = fileName;
        this.spelling = spelling;

        image = new ImageIcon(fileName);
    }

    public Image getImage() {
        return image.getImage();
    }

    public String[] getSpelling() {
        return spelling;
    }

    public String getFileName() {
        return fileName;
    }
}

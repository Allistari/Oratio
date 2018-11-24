import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Launcher.java
 * Creates OratioTree objects from a custom JSON file which contains the data and image url for each mouth shape
 * @author Joey Chik
 * created 2018-11-15
 * last modified 2018-11-18
 */

public class OratioTreeGenerator {


    public OratioTree generateTree(String jsonURL) {
        try {
            Scanner scanner = new Scanner(new File(jsonURL));
        } catch(IOException e) {
            return null;
        }

        OratioTree<MouthShape> tree = new OratioTree<>();



        return tree;
    }
}

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class JSONGenerator {
    private Gson gson;

    JSONGenerator() {
        this.gson = new Gson();
    }

    /**
     *
     * @param m
     * @param file
     * @return
     */
    public boolean generateJSON(MouthShape m, File file) {
        try {
            JsonWriter writer = new JsonWriter(new FileWriter(file));
        } catch(IOException e) {
            return false;
        }
        return true;
    }
}

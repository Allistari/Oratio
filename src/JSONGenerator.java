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
     * @param mArray
     * @param file
     * @return
     */
    public boolean generateJSON(MouthShape[] mArray, File file) throws IOException {
        JsonWriter writer;
        try {
            writer = new JsonWriter(new FileWriter(file));
        } catch (IOException e) {
            return false;
        }

        writer.beginArray();

        for (MouthShape m : mArray) {
            writeMouthShape(writer, m);
        }

        writer.endArray();

        writer.close();

        return true;
    }
    
    private void writeMouthShape(JsonWriter writer, MouthShape m) throws IOException
    {
        writer.beginObject();
        
        writer.name("fileName").value(m.getFileName());
        writer.name("spelling");
        writeArray(writer, m.getSpelling());
        
        writer.endObject();
    }
    
    private void writeArray(JsonWriter writer, String[] strings) throws IOException {
        writer.beginArray();
        
        for (String string : strings) {
            writer.value(string);
        }
        
        writer.endArray();
    }
}

import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * JsonGenerator.java
 * Creates a JSON file representing an array of MouthShape objects
 * @author Joey
 * created 2018-11-15
 * last modified 2018-11-25
 */
public class JsonGenerator {
    /**
     * generates a JSON file containing an array of MouthShapes
     * @param mList an OratioLinkedList of MouthShapes
     * @param file the file object to write to
     */
    public void generateJSON(OratioLinkedList<MouthShape> mList, String avatarPath, File file) throws IOException {
        JsonWriter writer;
        writer = new JsonWriter(new FileWriter(file));

        writer.beginArray();

        writer.beginObject();
        writer.name("avatar").value(avatarPath);
        writer.endObject();

        for (int i = 0; i < mList.size(); i++) {
            writeMouthShape(writer, mList.get(i));
        }

        writer.endArray();

        writer.close();
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

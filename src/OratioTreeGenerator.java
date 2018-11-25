import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Launcher.java
 * Creates OratioTree objects from a custom JSON file which contains the data and image url for each mouth shape
 * @author Joey Chik
 * created 2018-11-15
 * last modified 2018-11-24
 */

public class OratioTreeGenerator {
    public OratioTree generateTree(String jsonURL) throws IOException{
        FileReader fileReader;

        try {
            fileReader= new FileReader(new File(jsonURL));
        } catch(IOException e) {
            return null;
        }

        JsonReader jsonReader = new JsonReader(fileReader);

        OratioLinkedList<MouthShape> mList = new OratioLinkedList<>();

        // start reading json
        jsonReader.beginArray();

        while (jsonReader.hasNext()) {
            mList.add(readMouthShape(jsonReader));
        }

        jsonReader.endArray();

        jsonReader.close();
        // finish reading json

        OratioTree<OratioLinkedList<MouthShape>> tree = new OratioTree<>();

        return tree;
    }

    private MouthShape readMouthShape(JsonReader jsonReader) throws IOException{
        String fileName = null;
        String[] spelling = null;

        jsonReader.beginObject();

        while (jsonReader.hasNext()) {
            String name = jsonReader.nextName();

            if (name.equals("fileName")) {
                fileName = jsonReader.nextString();
            } else if (name.equals("spelling")) {
                spelling = readJsonStringArray(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }

        jsonReader.endObject();

        return new MouthShape(fileName, spelling);
    }

    private String[] readJsonStringArray(JsonReader jsonReader) throws IOException{
        OratioLinkedList<String> strings = new OratioLinkedList<>();

        jsonReader.beginArray();

        while (jsonReader.hasNext()) {
            strings.add(jsonReader.nextString());
        }

        jsonReader.endArray();

        return strings.toArray();
    }
}

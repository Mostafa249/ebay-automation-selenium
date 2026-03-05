package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class JsonReader {

    private static final String BASE_PATH = "src/tests/resources/testdata/";

    public static String getValue(String fileName, String key) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(new File(BASE_PATH + fileName));

            return rootNode.get(key).asText();

        } catch (Exception e) {
            throw new RuntimeException("Failed to read from JSON file: " + fileName, e);
        }
    }
}
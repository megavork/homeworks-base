package Market_11.converter;

import Market_11.Source.Item;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class HeyJackson {
    private final static String jacksonFile = "jackson.json";

    public static void toJSON(HashMap map) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(jacksonFile), map);
        System.out.println("Jackson here!");
    }

    public static Item backToJavaObj() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(jacksonFile), Item.class);
    }
}

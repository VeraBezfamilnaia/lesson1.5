package task3;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static String readString(String path) {
        JSONParser parser = new JSONParser();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            JSONArray array = (JSONArray) parser.parse(reader);
            return array.toString();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Unable to read string");
    }
}

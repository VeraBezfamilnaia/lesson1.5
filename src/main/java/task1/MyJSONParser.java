package task1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MyJSONParser {
    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();

    public static String listToJson(List<Employee> list) {
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        return gson.toJson(list, listType);
    }

    public static List<Employee> jsonToList(String json) throws ParseException {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(json);
        JSONArray jsonArray = (JSONArray) object;

        List<Employee> employees = new ArrayList<>();
        for (Object jsonObject : jsonArray) {
            Employee employee = gson.fromJson((JsonElement) jsonObject, Employee.class);
            employees.add(employee);
        }
        return employees;
    }
}


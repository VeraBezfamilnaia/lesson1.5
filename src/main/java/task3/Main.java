package task3;

import org.json.simple.parser.ParseException;
import task1.Employee;

import java.util.List;

import static task1.MyJSONParser.jsonToList;
import static task3.Reader.readString;

public class Main {
    public static void main(String[] args) throws ParseException {
        String json = readString("/Users/veralizunova/Desktop/lesson1.5/src/main/java/new_data.json");
        List<Employee> employees = jsonToList(json);
        System.out.println(employees);
    }
}

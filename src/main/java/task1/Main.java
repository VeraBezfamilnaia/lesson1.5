package task1;

import java.util.List;

import static task1.CSVParser.parseCSV;
import static task1.MyJSONParser.listToJson;
import static task1.Writer.writeString;

public class Main {
    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "src/main/java/data.csv";
        List<Employee> employees = parseCSV(columnMapping, fileName);
        String json = listToJson(employees);

        String destPath = "src/main/java/data.json";
        writeString(json, destPath);
    }
}

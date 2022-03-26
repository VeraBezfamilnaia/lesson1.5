package task2;

import org.xml.sax.SAXException;
import task1.Employee;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static task1.MyJSONParser.listToJson;
import static task1.Writer.writeString;
import static task2.XMLParser.parseXML;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String fileName = "src/main/java/data.xml";
        List<Employee> employees = parseXML(fileName);
        String json = listToJson(employees);

        String destPath = "src/main/java/data2.json";
        writeString(json, destPath);
    }
}

package task2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import task1.Employee;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
    private static final int ELEMENT_INDEX = 0;

    public static List<Employee> parseXML(String filePath) throws ParserConfigurationException, IOException, SAXException {
        NodeList nodes = getNodes(filePath);

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element element = (Element) node;
                String id = getContent(element, "id");
                String firstName = getContent(element, "firstName");
                String lastName = getContent(element, "lastName");
                String country = getContent(element, "country");
                String age = getContent(element, "age");

                employees.add(new Employee(
                        Long.parseLong(id),
                        firstName,
                        lastName,
                        country,
                        Integer.parseInt(age)));
            }
        }
        return employees;
    }

    private static NodeList getNodes(String filePath) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(filePath));

        Element root = document.getDocumentElement();
        return root.getChildNodes();
    }

    private static String getContent(Element element, String tag) {
        return element
                .getElementsByTagName(tag)
                .item(ELEMENT_INDEX)
                .getTextContent();
    }
}

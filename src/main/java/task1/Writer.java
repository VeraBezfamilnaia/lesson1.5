package task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void writeString(String str, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

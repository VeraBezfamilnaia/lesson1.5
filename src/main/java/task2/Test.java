package task2;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "Stt");
        map.put("Str", null);

        System.out.println(map);
    }
}

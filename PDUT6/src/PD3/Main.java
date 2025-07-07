package PD3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "uno");
        map.put("b", null);
        map.put("c", "tres");
        map.put("d", null);

        map.entrySet().removeIf(e -> e.getValue() == null);

        System.out.println(map);
    }

}

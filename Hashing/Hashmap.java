import java.util.*;

public class Hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Us", 50);
        hm.put("Nepal", 5);

        System.out.println(hm);

        System.out.println(hm.size());

        System.out.println(hm.isEmpty());

        System.out.println(hm.get("India"));

        System.out.println(hm.containsKey("Nepal"));
        System.out.println(hm.containsKey("Indonasia"));
        
        hm.remove("China");

        System.out.println(hm);

        Set<String> keys = hm.keySet();
        for (String k : keys) {
            System.out.println(k +" - " +hm.get(k));
        }
    }
}

import java.util.*;

public class FindItineary {

    public static String getStart(HashMap<String, String> hm) {
        HashMap<String, String> revhm = new HashMap<>();

        for (String string : hm.keySet()) {
            revhm.put(hm.get(string), string);
        }

        for (String string : hm.keySet()) {
            if (!revhm.containsKey(string)) {
                return string;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("chennai", "bengalauru");
        hm.put("mumbai", "delhi");
        hm.put("delhi", "goa");
        hm.put("goa", "chennai");

        String start = getStart(hm);

        System.out.print(start);

        for (String string : hm.keySet()) {
            System.out.print(" -> " + hm.get(start));
            start = hm.get(start);
        }
    }
}

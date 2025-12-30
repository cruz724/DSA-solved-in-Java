import java.util.*;

public class CountDistinctElement {
    public static void main(String[] args) {
        int num[] = {4,3,2,5,6,7,4,3,2,1};

        HashSet<Integer> hs = new HashSet<>();

        for (Integer integer : num) {
            hs.add(integer);
        }

        System.out.println(hs.size());
    }
}

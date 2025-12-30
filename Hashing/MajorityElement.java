import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int arr[] = {1,3,2,5,1,3,1,5,1};

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i =0; i<arr.length; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }

        Set<Integer> keySet = hm.keySet();
        for (Integer key : keySet) {
            if (hm.get(key) > arr.length/3) {
                System.out.println(key);
            }
        }
    }
}

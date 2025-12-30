import java.util.*;
public class UnionIntersection {
    public static void main(String[] args) {
        
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();

        for (Integer integer : arr1) {
            hs1.add(integer);
        }
        for (Integer integer : arr2) {
            hs1.add(integer);
        }

        System.out.println("Union - "+hs1.size());

        for (Integer integer : arr1) {
            hs2.add(integer);
        }
        int count =0;
        for (Integer integer : arr2) {
            if (hs2.contains(integer)) {
                count++;
                hs2.remove(integer);
            }
        }

        System.out.println("intersection- " + count);
    }
}

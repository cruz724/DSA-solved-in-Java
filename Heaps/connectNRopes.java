import java.util.*;
public class connectNRopes {
    public static void main(String[] args) {
        int ropes[] = {4,3,2,6};
        int ans =0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        while (pq.size() >1) {
            
            int a = pq.remove();
            int b = pq.remove();

            int sum = a+b;
            ans += sum;

            pq.add(sum);

        }

        System.out.println(ans);
    }
}

import java.util.PriorityQueue;

public class slidingWindowMaximum {

    static class pair implements Comparable<pair>{
        int idx;
        int value;

        public pair(int idx, int value){
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(pair p2){
            return p2.value - this.value;
        }
    }

    public static void main(String[] args) {
        // int arr[] = {1,3,-1,-3,5,3,6,7};
        int arr[] = {1,2,3,4,5,6,7,8,9,0};
        int k = 3; //window size
        int res[] = new int[arr.length-k+1]; //n-k+1

        PriorityQueue<pair> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(new pair(i, arr[i]));
        }

        res[0] = pq.peek().value;

        for (int j = k; j < arr.length; j++) {
            while (pq.size() >0 && pq.peek().idx == (j-k)) {
                pq.remove();
            }

            pq.add(new pair(j, arr[j]));
            res[j-k+1] = pq.peek().value;
        }

        for (int j2 = 0; j2 < res.length; j2++) {
            System.out.print(res[j2] + " ");
        }
    }
}

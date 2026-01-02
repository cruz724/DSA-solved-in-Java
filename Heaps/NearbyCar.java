import java.util.*;

public class NearbyCar {

    public static class priorityCar implements Comparable<priorityCar> {
        int x;
        int y;
        int dis;
        int idx;

        public priorityCar(int x, int y, int dis, int idx) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.idx = idx;
        }

        @Override
        public int compareTo(priorityCar p2){
            return this.dis - p2.dis;
        }
    }

    public static void main(String[] args) {
        int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        PriorityQueue<priorityCar> pq = new PriorityQueue<>();

        for (int i = 0; i < pts.length; i++) {
            int dissq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new priorityCar(pts[i][0], pts[0][1], dissq, i));
        }

        for (int j = 0; j < k; j++) {
            System.out.println("C" + pq.remove().idx);
        }

    }
}

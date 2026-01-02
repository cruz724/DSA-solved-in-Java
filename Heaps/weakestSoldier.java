import java.util.PriorityQueue;

public class weakestSoldier {

    static class row implements Comparable<row> {
        int count;
        int idx;

        public row(int count, int idx){
            this.count = count;
            this.idx = idx;
        }

        @Override
        public int compareTo(row r2){
            if (this.count == r2.count) {
                return this.idx - r2.idx;
            }else{
                return this.count - r2.count;
            }
        }
    }
    public static void main(String[] args) {
        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};

        int k =2;

        PriorityQueue<row> pq = new PriorityQueue<>();

        for (int i = 0; i < army.length; i++) {
            int cont =0;
            for (int j = 0; j < army[0].length; j++) {
                cont += army[i][j] == 1 ? 1 :0;
            }

            pq.add(new row(cont, i));
        }

        for (int j = 0; j < k; j++) {
            System.out.println("R" + pq.remove().idx);
        }

    }
}

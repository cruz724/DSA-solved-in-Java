import java.util.*;

public class CreateGraph {

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static void main(String[] args) {
        
        /*
        Vertices: 0, 1, 2, 3, 4

                (5)
           0 -------- 1
                     | \
                 (1) |  \(3)
                     |   \
                     2 --- 3
                      \ (1)
                       \
                       (2)
                         4     
*/



        int v=5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        //0 -> vertiex
        graph[0].add(new Edge(0, 1, 5));

        //1-> vertiex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        //2-> vertices
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        //3-> vertivces
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        //4-> vertiex
        graph[4].add(new Edge(4, 2, 2));


        //2's nebiour print
        for(int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
    }
}

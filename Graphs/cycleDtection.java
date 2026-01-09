import java.util.*;

public class cycleDtection {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        // initialize adjacency list
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // 3
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        // 4
        graph[4].add(new Edge(4, 3));
    }

    public static void main(String[] args) {
        
        /*
        |       0 -------- 3
        |      /|          |
        |     / |          |
        |    1  |          4
        |     \ |
        |      \|
        |       2
        */

        int V = 5
        ArrayList<Edge> graph [] = new ArrayList [V];
        createGraph (graph);
    }
}

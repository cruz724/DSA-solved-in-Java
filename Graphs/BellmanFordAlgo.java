import java.util.ArrayList;

public class BellmanFordAlgo {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

     static void createGraph(ArrayList<Edge>[] graph) {

        // Initialize each ArrayList
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src){
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (src != i) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int v= graph.length;

        for(int i=0; i<v-1; i++){
            for(int j=0; j<graph.length; j++){
                for(int k=0; k< graph[j].size(); k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int dest = e.dest;
                    int wt = e.wt;

                    if (dist[u] !=Integer.MAX_VALUE && dist[u] + wt < dist[dest] ) {
                        dist[dest] = dist[u] + wt;                       
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList [V];
        createGraph (graph);

        bellmanFord(graph, 0);
    }
}

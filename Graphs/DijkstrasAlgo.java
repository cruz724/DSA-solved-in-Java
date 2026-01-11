import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgo {
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

    static class pair implements Comparable<pair>{
        int n;
        int paths;
        public pair(int n, int paths){
            this.n = n;
            this.paths = paths;
        }

        @Override
        public int compareTo(pair p2){
            return this.paths - p2.paths;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        // initialize adjacency list
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static void dijkstras(ArrayList<Edge> graph[], int src){
        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (i!=src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(src, 0));

        while (!pq.isEmpty()) {
            pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;

                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e  = graph[curr.n].get(i);

                    if (dist[e.src] + e.wt < dist[e.dest])  {
                        dist[e.dest] = dist[e.src] + e.wt;
                        pq.add(new pair(e.dest, dist[e.dest]));
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph [] = new ArrayList [V];
        createGraph (graph);

        dijkstras(graph, 0);
    }
}

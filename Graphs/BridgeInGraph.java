import java.util.*;

public class BridgeInGraph {

    // Edge class
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // global timer
    static int time = 0;

    // Function to find bridges
    public static void tarjanBridge(ArrayList<Edge>[] graph, int V) {
        int[] dt = new int[V];       // discovery time
        int[] low = new int[V];      // lowest discovery time reachable
        boolean[] vis = new boolean[V];

        // For disconnected graph
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis);
            }
        }
    }

    // DFS function
    public static void dfs(ArrayList<Edge>[] graph, int curr, int par,
                           int[] dt, int[] low, boolean[] vis) {

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            // ignore parent edge
            if (neigh == par) {
                continue;
            }

            // if not visited -> DFS
            if (!vis[neigh]) {
                dfs(graph, neigh, curr, dt, low, vis);

                // update low value
                low[curr] = Math.min(low[curr], low[neigh]);

                // Bridge condition
                if (dt[curr] < low[neigh]) {
                    System.out.println("Bridge : " + curr + " --- " + neigh);
                }

            } else {
                // back edge case
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    // Create Graph (Undirected)
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Example Graph
        // 0 -- 1
        // |    |
        // 2 -- 3 -- 4
        // Bridge is: 3---4

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 0));

        graph[1].add(new Edge(1, 3));
        graph[3].add(new Edge(3, 1));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println("Bridges in the graph are:");
        tarjanBridge(graph, V);
    }
}

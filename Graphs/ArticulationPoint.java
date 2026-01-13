import java.util.*;

public class ArticulationPoint {

    // Edge class
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static int time = 0; // global timer

    // Function to get articulation points
    public static void getAP(ArrayList<Edge>[] graph, int V) {
        int[] dt = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        boolean[] ap = new boolean[V];

        // for disconnected graph
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, ap);
            }
        }

        // Print all articulation points
        System.out.println("Articulation Points are:");
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println("AP : " + i);
            }
        }
    }

    // DFS function
    public static void dfs(ArrayList<Edge>[] graph, int curr, int par,
                           int[] dt, int[] low, boolean[] vis, boolean[] ap) {

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            // if neighbor is parent -> ignore
            if (neigh == par) {
                continue;
            }

            // back edge case
            if (vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } 
            // forward edge case
            else {
                dfs(graph, neigh, curr, dt, low, vis, ap);

                low[curr] = Math.min(low[curr], low[neigh]);

                // articulation point condition (not root)
                if (par != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true;
                }

                children++;
            }
        }

        // root node condition
        if (par == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    // Create Graph (Undirected)
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Example Graph:
        // 0 -- 1 -- 2
        // |    |
        // 3 -- 4
        // AP: 1 and 0

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[0].add(new Edge(0, 3));
        graph[3].add(new Edge(3, 0));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));

        graph[4].add(new Edge(4, 1));
        graph[1].add(new Edge(1, 4));
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        getAP(graph, V);
    }
}

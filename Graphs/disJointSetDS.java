public class disJointSetDS {
    static int n =7;
    static int parent[];
    static int rank[];

    static void init() {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < 7; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA == parB)
            return;

        if (rank[parA] < rank[parB]) {
            parent[parA] = parB;
        } else if (rank[parA] > rank[parB]) {
            parent[parB] = parA;
        } else {
            parent[parB] = parA;
            rank[parA]++;
        }
    }

    public static void main(String[] args) {
        init();

        System.out.println(find(3));

        union(1, 3);
        System.out.println(find(3));

        union(2, 4);
        union(3, 6);
        union(1, 4);

        System.out.println(find(3));
        System.out.println(find(4));

        union(1, 5);
    }
}

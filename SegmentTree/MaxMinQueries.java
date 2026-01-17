package SegmentTree;

public class MaxMinQueries {

    static int tree[];

    public static void init(int n){
        tree = new int[4*n];
    }
    public static void buildST(int arr[], int si, int sj, int i){
        if (si == sj) {
            tree[i] = arr[si];
            return;
        }

        int mid = (si + sj)/2;

        buildST(arr, si, mid, 2*i+1);
        buildST(arr, mid+1, sj, 2*i+2);

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    public static int getmaxUtil(int i, int si,int sj,int qi,int qj){
        if (qj<si || qi>sj) {
            return Integer.MIN_VALUE;
        }else if (si>=qi && sj<=qj) {
            return tree[i];
        }else{
            int mid = (si+sj)/2;
            int left = getmaxUtil(2*i+1, si, mid, qi, qj);
            int right = getmaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(left,right);
        }
    }

    public static int getmax(int arr[], int qi,int qj){
        int n = arr.length;
        return getmaxUtil(0, 0, n-1, qi, qj);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int newval){
        if (idx>sj || idx<si) {
            return;
        }
        tree[i] = Math.max(newval, tree[i]);

        if (si!=sj) {
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, newval);
            updateUtil(2*i+2, mid+1, sj, idx, newval);
        }
    }
    public static void update(int arr[], int idx, int newval){
        int n = arr.length;
        arr[idx] = newval;

        updateUtil(0, 0, n-1, idx, newval);
    }
    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;

        init(n);
        buildST(arr, 0, n-1, 0);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

        System.out.println();
        int max = getmax(arr, 2, 5);
        System.out.println(max);

        update(arr, 2, 20);
        int max1 = getmax(arr, 2, 5);
        System.out.println(max1);
    }
}

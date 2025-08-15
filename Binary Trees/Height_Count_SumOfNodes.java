import java.util.*;

public class Height_Count_SumOfNodes {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        int ans = (Math.max(lh, rh) + 1);

        return ans;
    }

    public static int count(Node root){
        if (root == null) {
            return 0;
        }
        int leftcount = count(root.left);
        int rightcount = count(root.right);

        int finalcount = leftcount + rightcount + 1;

        return finalcount;
    }

    public static int sum(Node root){
        if (root == null) {
            return 0;
        }

        int leftsum = sum(root.left);
        int rightsum = sum(root.right);
        int sum = leftsum + rightsum + root.data;

        return sum;
    }

    public static void main(String[] args) {
        /*     
         *      1
         *     / \
         *    2   3
         *   /\   /\
         *  4  5 6  7
         * 
         */

         Node root = new Node(1);
         root.left =new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right.right = new Node(7);
         root.right.left = new Node(6);

        System.out.println("height of tree is : " + height(root));

        System.out.println("count of nodes: " + count(root));

        System.out.println("Sum of nodes: " + sum(root));
    }
}

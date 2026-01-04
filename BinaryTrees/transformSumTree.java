import java.util.*;

public class transformSumTree {

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

    public static void printLevelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    // Transform to Sum Tree
    public static int transform(Node root) {
        
        if(root == null) return 0;
        
        int leftsum = transform(root.left);
        int rightsum = transform(root.right);

        int curr = root.data;
        root.data = leftsum+rightsum;

        return curr+root.data;
    }

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Original Tree (Level Order):");
        printLevelOrder(root);

        transform(root);

        System.out.println("Sum Tree (Level Order):");
        printLevelOrder(root);
    }
}


public class Diameter_OfTree {
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

    public static int diameter(Node root){
        if (root == null) {
            return 0;            
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);

        int selfDia = leftHeight + rightHeight +1;

        return Math.max(Math.max(rightDia, leftDia), selfDia);
    }
    public static void main(String[] args) {
        /*
         * 1
         * 
         * / \
         * 2 3
         * /\ /\
         * 4 5 6 7
         * 
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        root.right.left = new Node(6);

        System.out.println(diameter(root));

    }
}

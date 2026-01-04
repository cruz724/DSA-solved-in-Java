public class Diameter_2 {
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

    static class Info{
        int diameter;
        int height;

        Info(int diameter, int height){
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Info Clac_diameter(Node root){
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = Clac_diameter(root.left);
        Info rightInfo = Clac_diameter(root.right);

        int finalDia = Math.max((leftInfo.height + rightInfo.height + 1), Math.max(leftInfo.diameter, rightInfo.diameter));
        int finalht = Math.max(leftInfo.height, rightInfo.height) +1;

        return new Info(finalDia, finalht);
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

        Info ans = Clac_diameter(root);
        System.out.println("diameter of tree is: " +ans.diameter );
        System.out.println("height of tree is: " +ans.height );
    }
}

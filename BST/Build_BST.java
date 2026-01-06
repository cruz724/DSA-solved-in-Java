
public class Build_BST {

    static class Node{
        int data;
        Node left , right;

        Node(int data){
            this.data = data;
        }
    }
    //----------------------------INORDER PRINT--------------------------------------------
    public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
    }

    //-----------------------------INSERT------------------------------------------
    public static Node insert(Node root , int val){
        if (root == null) {
            return root = new Node(val);
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    //---------------------------SEARCH-----------------------------------------
    public static boolean search(Node root ,int val){
        if (root == null) {
            return false;
        }
        if (root.data == val) {
            return true;
        }else if (root.data > val) {
            return search(root.left, val);
        }else{
            return search(root.right, val);
        }
    }


    //----------------------DELETE--------------------------------------------
    public static Node delete(Node root, int val){
        if (root.data < val) {
            root.right = delete(root.right, val);            
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }else{

            // no child
            if (root.left == null && root.right == null) {
                return null;
            }

            // 1 child node
            if (root.left == null) {
                return root.right;
            }else if (root.right == null) {
                return root.left;
            }

            //2 child
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    private static Node findInorderSuccessor(Node root){
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    //--------------------Print in range ------------------------
    public static void printInRange(Node root, int k1, int k2){
        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }else if(root.data > k2){
            printInRange(root.left, k1, k2);
        }else{
            printInRange(root.right, k1, k2);
        }
    }

    //---------------------------print leaf paths-----------------------------

    public static void main(String[] args) {

        // int values[] = {5,1,3,4,2,7};
        int values[] = {1,3,4,5,6,8,10,11,14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        System.out.println(search(root, 0));
        

        delete(root, 3);
        inorder(root);
        System.out.println();

        printInRange(root,3,11);
    }
}

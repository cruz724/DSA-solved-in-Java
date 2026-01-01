import java.util.*;

public class uniqueSubstrings {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean search(String key) {

        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.eow;
    }

    public static int countNodes(Node root){
        int count =0;

        if (root == null) {
            return 0;
        }

        for(int i =0; i<root.children.length; i++){
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
                
            }
        }
        return count +1;
    }

    public static void main(String[] args) {
        String str ="ababa";

        //suffix -> insert karna hai 
        for (int i=0; i<str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(countNodes(root));
    }
}

import java.util.*;
public class LongestWordWithAllPrefix {

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

    public static String ans ="";

    public static void longestword(Node root,StringBuilder temp){
        if (root == null) {
            return;
        }

        for(int i=0; i<26; i++){
            if (root.children[i]!= null && root.children[i].eow == true) {
                char ch = (char)(i +'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestword(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String word[] = { "a", "banana", "ap", "app", "appl", "apple", "apply" };

        for (String k : word) {
            insert(k);
        }

        longestword(root, new StringBuilder(""));

        System.out.println(ans);

    }
}

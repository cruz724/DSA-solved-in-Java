import java.util.*;

import org.w3c.dom.Node;

public class HashmapImplementaion {

    static class MyHashMap<K, V> {

        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        @SuppressWarnings("unchecked")
        private LinkedList<Node> bucket[];

        @SuppressWarnings("unchecked")

        public MyHashMap() {
            this.N = 4;
            this.n = 0;
            this.bucket = new LinkedList[4];

            for (int i = 0; i < 4; i++) {
                this.bucket[i] = new LinkedList<>();
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");

            for (int i = 0; i < N; i++) {
                for (Node node : bucket[i]) {
                    sb.append(node.key)
                            .append("=")
                            .append(node.value)
                            .append(", ");
                }
            }

            if (sb.length() > 1) {
                sb.setLength(sb.length() - 2);
            }

            sb.append("}");
            return sb.toString();
        }

        private int hashfunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = bucket[bi];
            int di = 0;

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key.equals(key)) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node> oldbucket[] = bucket;

            N = N * 2;
            bucket = new LinkedList[N];

            for (int i = 0; i < N; i++) {
                bucket[i] = new LinkedList<>();
            }

            n = 0;
            for (int i = 0; i < oldbucket.length; i++) {
                LinkedList<Node> ll = oldbucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashfunction(key);
            int di = SearchInLL(key, bi);

            if (di != -1) {
                Node node = bucket[bi].get(di);
                node.value = value;
            } else {
                bucket[bi].add(new Node(key, value));
                n++;
            }

            double lamda = (double) n / N;
            if (lamda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashfunction(key);
            return SearchInLL(key, bi) != -1;
        }

        public V remove(K key) {
            int bi = hashfunction(key);
            int di = SearchInLL(key, bi);

            if (di != -1) {
                Node node = bucket[bi].remove(di);
                n--;
                return node.value;
            }
            return null;
        }

        public V get(K key) {
            int bi = hashfunction(key);
            int di = SearchInLL(key, bi);

            if (di != -1) {
                return bucket[bi].get(di).value;
            }
            return null;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (Node node : bucket[i]) {
                    keys.add(node.key);
                }
            }

            return keys;
        }

    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        // put() calls
        map.put("India", 100);
        map.put("China", 150);
        map.put("UK", 50);
        map.put("Nepal", 5);

        System.out.println(map);

        map.put("India", 120);

        // get()
        System.out.println(map.get("India")); // 120
        System.out.println(map.get("China")); // 150

        // containsKey()
        System.out.println(map.containsKey("China")); // true
        System.out.println(map.containsKey("UK")); // false

        // remove()
        System.out.println(map.remove("Nepal")); // 5
        System.out.println(map.get("Nepal")); // null

         ArrayList<String> keys = map.keySet();
    System.out.println(keys);
    }
}

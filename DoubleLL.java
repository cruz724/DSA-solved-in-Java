public class DoubleLL {

    public class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // addFirst
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // addLast
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // print
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // removeFirst
    public int removeFirst() {

        if (head == null) {
            System.out.println("empty");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    // reverse
    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }

        Node temp = head;
        head = tail;
        tail = temp;
    }

    public void deleteNafterM(int M, int N) {
        Node curr = head;

        while (curr != null) {
            for (int i = 1; i < M && curr != null; i++) {
                curr = curr.next;
            }

            if (curr == null) {
                return;
            }

            Node temp = curr.next;

            for (int i = 0; i < N && temp != null; i++) {
                temp = temp.next;
            }

            curr.next = temp;
            curr = temp;
        }

    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(8);
        dll.addFirst(7);
        dll.addFirst(6);
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();

        // dll.removeFirst();
        // dll.print();

        dll.addLast(9);
        dll.print();

        // dll.reverse();
        // dll.print();

        dll.deleteNafterM(2,2);
        dll.print();
    }
}

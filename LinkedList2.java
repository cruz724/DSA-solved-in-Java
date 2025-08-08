import java.util.*;

public class LinkedList2 {

     // Define Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Static head of the list
    static Node head;
    
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void removeCycle(){
        //dectect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow==fast) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        //find meeting point

        slow = head;
        Node prev = null;

        while (slow!=fast) {
            prev = fast; 
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle -> last.next =null

        prev.next = null;
    }


    public static void zigZag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next= null;

        Node prev = null;
        Node next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //alt merge - zigzag merge 
        Node left = head;
        Node right = prev;

        Node nextLeft;
        Node nextRight;

        while (left!=null && right!=null) {
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }

        
    }

    public static void main(String[] args) {

        head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creates a cycle (40 -> 20)

        // System.out.println(isCycle()); // Expected: false
        // removeCycle();
        // System.out.println(isCycle());

    }
}

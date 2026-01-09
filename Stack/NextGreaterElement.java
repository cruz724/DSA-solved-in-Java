package Stack;
import java.util.*;

public class NextGreaterElement {

    public static void FindNextGreaterElement(int arr[], int NextGreaterElement[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.empty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            if (s.empty()) {
                NextGreaterElement[i] = -1;
            } else {
                NextGreaterElement[i] = arr[s.peek()];
            }

            s.push(i);
        }
    }

    

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int NextGreaterElement[] = new int[arr.length];

        FindNextGreaterElement(arr, NextGreaterElement);

        for (int i = 0; i < NextGreaterElement.length; i++) {
            System.out.println(NextGreaterElement[i] + "  ");
        }
    }
}

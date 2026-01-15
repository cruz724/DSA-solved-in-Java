import java.util.*;

public class FibonacciFunctions {

    // 1) Normal Recursive Fibonacci (Time: O(2^n))
    public static int fibRecursive(int n) {
        if (n == 0 || n == 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // 2) DP Memoization Fibonacci (Time: O(n))
    public static int fibMemo(int n, int[] dp) {
        if (n == 0 || n == 1) return n;

        if (dp[n] != -1) return dp[n];

        dp[n] = fibMemo(n - 1, dp) + fibMemo(n - 2, dp);
        return dp[n];
    }

    // 3) DP Tabulation Fibonacci (Time: O(n))
    public static int fibTab(int n) {
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println("Fibonacci Recursive: " + fibRecursive(n));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Fibonacci Memoization: " + fibMemo(n, dp));

        System.out.println("Fibonacci Tabulation: " + fibTab(n));
    }
}

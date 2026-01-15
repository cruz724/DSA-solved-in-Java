import java.util.*;

public class ClimbStairsDP {

    // 1) Normal Recursion (Time: O(2^n))
    public static int countWaysRec(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        return countWaysRec(n - 1) + countWaysRec(n - 2);
    }

    // 2) Memoization (Top-Down DP) (Time: O(n))
    public static int countWaysMemo(int n, int[] dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        if (dp[n] != -1) { // already calculated
            return dp[n];
        }

        dp[n] = countWaysMemo(n - 1, dp) + countWaysMemo(n - 2, dp);
        return dp[n];
    }

    // 3) Tabulation (Bottom-Up DP) (Time: O(n))
    public static int countWaysTab(int n) {
        if (n == 0) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 1;

        System.out.println("Normal Recursion Answer: " + countWaysRec(n));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Memoization Answer: " + countWaysMemo(n, dp));

        System.out.println("Tabulation Answer: " + countWaysTab(n));
    }
}

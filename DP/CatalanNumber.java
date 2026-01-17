import java.util.*;

public class CatalanNumber {

    // 1) Normal Recursion (Exponential Time)
    public static long catalanRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalanRec(i) * catalanRec(n - i - 1);
        }
        return ans;
    }

    // 2) Memoization (Top-Down DP)
    public static long catalanMemo(int n, long dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalanMemo(i, dp) * catalanMemo(n - i - 1, dp);
        }

        dp[n] = ans;
        return dp[n];
    }

    // 3) Tabulation (Bottom-Up DP)
    public static long catalanTab(int n) {
        long dp[] = new long[n + 1];

        dp[0] = 1;
        if (n >= 1) dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            long ans = 0;
            for (int j = 0; j < i; j++) {
                ans += dp[j] * dp[i - j - 1];
            }
            dp[i] = ans;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Catalan using Recursion: " + catalanRec(n));

        long dp[] = new long[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Catalan using Memoization: " + catalanMemo(n, dp));

        System.out.println("Catalan using Tabulation: " + catalanTab(n));
    }
}

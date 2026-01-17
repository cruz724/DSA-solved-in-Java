import java.util.*;

public class CountingTrees {

    public static int CountBST(int n) {
        int dp[] = new int[n + 1];

        dp[0] = 1;
        if (n >= 1) dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int ans = 0;
            for (int j = 0; j < i; j++) {
                int left = dp[j];
                int right = dp[i - j - 1];
                ans += left * right;
            }
            dp[i] = ans;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Count of BSTs - " + CountBST(n));
    }
}

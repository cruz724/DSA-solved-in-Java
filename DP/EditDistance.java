import java.util.*;

public class EditDistance {

    public static int editDis(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i==0) {
                    dp[i][j] = j;
                }else if (j==0) {
                    dp[i][j] = i;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]; //same
                }else{
                    int ans1 = dp[i][j-1]; //add
                    int ans2 = dp[i-1][j]; //delete
                    int ans3 = dp[i-1][j-1]; //replace

                    dp[i][j] = Math.min(ans1, Math.min(ans2, ans3)) +1;
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";

        System.out.println(editDis(s1,s2));
    }
}

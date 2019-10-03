package ChallengeSet.Leetcode;

import java.util.*;

public class Ruby {
    
    public static int maxProfit(int n, int a, int b, int c) {
        int[][][] dp = new int[a+1][b+1][c+1];
        for (int l=1; l<=n; l++) {
            for (int i=a; i>=0; i--) {
                for (int j=b; j>=0; j--) {
                    for (int k=c; k>=0; k--) {
                        if (i >= 5) dp[i][j][k] = Math.max(dp[i][j][k], dp[i-5][j][k] + 5*10);
                        if (j >= 5) dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-5][k] + 5*5);
                        if (k >= 1) dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k-1] + 1*25);
                    }
                }
            }
        }
        return dp[a][b][c];
    }
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int res = maxProfit(3, 100, 4, 1);
        System.out.println(res);
    }

}
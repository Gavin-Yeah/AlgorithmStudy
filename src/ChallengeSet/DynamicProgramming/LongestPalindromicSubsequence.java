
public class LongestPalindromicSubsequence {
/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 * leetcode 516
 * 回文子序列 不要求连续
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	    public static int longestPalindromeSubseq(String s) {
	        int[][] dp = new int[s.length()][s.length()];
	        
	        for (int i = s.length() - 1; i >= 0; i--) {
	            dp[i][i] = 1;
	            for (int j = i+1; j < s.length(); j++) {
	                if (s.charAt(i) == s.charAt(j)) {
	                    dp[i][j] = dp[i+1][j-1] + 2;
	                } else {
	                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
	                }
	            }
	        }
	        return dp[0][s.length()-1];
	    }
	
}

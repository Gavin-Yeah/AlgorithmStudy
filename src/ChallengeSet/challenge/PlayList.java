package ChallengeSet.challenge;

public class PlayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(list(3,3,1));
	}
	public static int list(int n, int l,int k) {
		int mod=1_000_000_007;
		long [][]dp=new long[l+1][n+1];
		dp[0][0]=1;
		for(int i=1;i<=l;i++) {
			for(int j=1;j<=n;j++) {
				//最后一首是新歌 则新歌可从（m-j+1）里选
				dp[i][j]+=dp[i-1][j-1]*(n-j+1);
				//最后一首是老歌，有k限制，则只能从（j-k）里选 而且如果j小于k，则没法选老歌
				dp[i][j]+=dp[i-1][j]*Math.max(j-k, 0);
				dp[i][j]%=mod;
			}
		}
		return (int)dp[l][n];
	}
}

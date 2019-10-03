package ChallengeSet.Drawbridge;

public class ConsecutiveNumberSum {
	
	/**
	 * leetcode 829
	 * servicetitan
	 * Given a positive integer N, 
	 * how many ways can we write it as a sum of consecutive positive integers?
	 * ((n+1)+(n+k))k/2=N
	 * @param N
	 * @return
	 */
	public int consecutiveNumbersSum(int N) {
	       int ans = 0;
	    //   int m=(int)Math.sqrt(2N);
	        for (int k = 1; k <= (int)Math.sqrt(2*N); k++){
	                if((N-(k*k+k)/2)%k==0){
	                    ans++;
	                }
	            }
	        return ans;
	    }
}

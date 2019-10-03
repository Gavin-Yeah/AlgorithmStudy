
public class HouseRubber {
/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed,
 *  the only constraint stopping you from robbing each of them is that adjacent houses have security system
 *  connected and it will automatically contact the police if two adjacent houses were broken into 
 *  on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]=new int[4];
//		for(int i=0;i<20;i++) {
//			num[i]=(int)(Math.random()*30);
//			System.out.print(num[i]+" ");
//		}
		num[0]=3;
		num[1]=2;
		num[2]=1;
		num[3]=4;
		System.out.println(rob(num));
	}
	public static int rob(int []num) {
		if(num.length==0||num==null)return 0;
		if(num.length==1) return num[0];
		if(num.length==2) return Math.max(num[0], num[1]);
	int [] dp=new int [num.length];
	dp[0]=num[0];
	dp[1]=Math.max(num[0], num[1]);
	for(int i=2;i<num.length;i++) {
		dp[i]=Math.max(num[i]+dp[i-2], dp[i-1]);
	}
	
		return dp[num.length-1];
		
	}
}

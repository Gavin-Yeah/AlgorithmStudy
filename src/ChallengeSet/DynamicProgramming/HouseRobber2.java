
public class HouseRobber2 {
/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have 
 * security system connected and it will automatically contact the police if two adjacent houses 
 * were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.


 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]=new int[20];
		for(int i=0;i<20;i++) {
			num[i]=(int)(Math.random()*30);
			System.out.print(num[i]+" ");
			
		}
		System.out.println("\n");
		int a= rob2(num);
		System.out.println(a);
	}
	public static int rob2(int num[]) {
		if(num.length==0||num==null)return 0;
		if(num.length==1) return num[0];
		if(num.length==2) return Math.max(num[0], num[1]);
		int dp1[]=new int [num.length];
		int dp2[]=new int [num.length];
		dp1[0]=num[0];
		dp1[1]=Math.max(num[0], num[1]);
		for(int i=2;i<num.length-1;i++) {
			dp1[i]=Math.max(num[i]+dp1[i-2], dp1[i-1]);
		}
		dp2[1]=num[1];
		dp2[2]=Math.max(num[2], num[1]);
		for(int i=3;i<num.length;i++) {
			dp2[i]=Math.max(num[i]+dp1[i-2], dp1[i-1]);
		}
		System.out.println(dp1[num.length-2]);
		System.out.println(dp2[num.length-1]);
		return Math.max(dp1[num.length-2], dp2[num.length-1]);
	}
}

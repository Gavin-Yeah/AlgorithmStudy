package ChallengeSet.challenge;

public class LongestSubarray {
	public static void main(String[] args) {
		int[]arr= {1,2,9,1,2,3};
		System.out.println(sub(arr,7));
	}
	public static int sub(int []arr, int k) {
		int l=0,r=0;
		int max=0;
		int sum=0;
		int count=0;
		for(int i=0;i<arr.length;i++) {
			count++;
			sum+=arr[i];
		while(sum>k) {
				sum-=arr[l];
				count--;
				l++;
			}
		if(max<count) {
			max=count;
		}
		}
		return max;
	}
}

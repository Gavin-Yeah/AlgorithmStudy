package ChallengeSet.challenge;

import java.util.Arrays;

public class ArrayReduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {1,3,5,7};
		System.out.println(reduce(arr));
	}
	public static int reduce(int[] arr) {
		
		
		if(arr.length<=1||arr==null)return 0;
		
		Arrays.sort(arr);
		int num[]=new int[arr.length];
		num[0]=arr[0];
		//int sum=arr[0]+arr[1];
		for(int i=1;i<arr.length;i++) {
			num[i]=num[i-1]+arr[i];
		}
		int sum=0;
		for(int i=1;i<arr.length;i++) {
			sum+=num[i];
		}
		return sum;
	}
}

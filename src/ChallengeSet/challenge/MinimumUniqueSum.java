package ChallengeSet.challenge;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumUniqueSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {1,1,1,1};
		System.out.println(min(arr));
	}
	public static int min(int[]arr) {
		Arrays.sort(arr);
		if(arr==null||arr.length==0)return 0;
		int sum=arr[0];
		int pre=arr[0];
		for(int i=1;i<arr.length;i++) {
			while(arr[i]<=pre) {
				arr[i]++;
			}
			sum+=arr[i];
			pre=arr[i];
		}
		return sum;
	}
}

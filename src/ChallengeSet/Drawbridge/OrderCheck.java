package ChallengeSet.Drawbridge;

import java.util.Arrays;

public class OrderCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,1,3,4,1};
		System.out.println(orderCheck(arr));
	}
	public static int orderCheck(int []arr) {
		int []temp=arr.clone();
		Arrays.sort(temp);
		int count=0;
		for(int i = 0; i < arr.length;i++) {
			if(temp[i]!=arr[i])count++;
		}
		return count;
	}
}

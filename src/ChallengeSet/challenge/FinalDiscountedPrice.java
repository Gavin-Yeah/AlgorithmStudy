package ChallengeSet.challenge;

import java.util.Arrays;

public class FinalDiscountedPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(price(new int[]{5,1,3,4,6,2})));
	}
	public static int[] price(int arr[]) {
		int[]ret=new int[2];
		ret[0]=0;
		ret[1]=0;
		
		tag:for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>=arr[j]) {
					arr[i]-=arr[j];
					ret[0]+=arr[i];
					continue tag;
				}
				
			}
			ret[0]+=arr[i];
			ret[1]++;
		}
		return ret;
	}
}

package ChallengeSet.challenge;

public class Metals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(metal(new int[] {26,103,59},100,10));
	}
	public static int metal(int[]arr, int cost, int price) {
		int max=0;
		int maxLen=0;
		for(int i=0;i<arr.length;i++) {
			if(maxLen<arr[i])maxLen=arr[i];
		}
		for(int j=1;j<=maxLen;j++) {
			int sum=0;
			int piece=0;
			int cut=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>=j) {
			piece+=arr[i]/j;
			if(arr[i]%j==0) {
				cut+=arr[i]/j-1;
			}else {
				cut+=arr[i]/j;
			}
			}
		}
			sum=j*piece*price-cost*cut;
			if(sum>max) {
				max=sum;
			//	System.out.println(j);
			}
		}
		return max;
	}
}

package ChallengeSet.challenge;

public class Triplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {3,1,2,4};
		System.out.println(triplet(arr,7));
	}
	public static int triplet(int[]arr, int t) {
		
		int count=0;
		for(int a=0;a<arr.length;a++) {
			for(int b=a+1;b<arr.length;b++) {
				for(int c=b+1;c<arr.length;c++) {
					if(arr[a]+arr[b]+arr[c]<=t) {
						count++;
					}
				}
			}
		}
		return count;
	}
}

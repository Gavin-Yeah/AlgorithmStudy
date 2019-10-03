package ChallengeSet.challenge;

public class ArrayGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int minMove(int[]arr) {
		int min=arr[0];
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			if(min>arr[i])min=arr[i];
		}
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i]-min;
		}
		return sum;
	}

}

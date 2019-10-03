package ChallengeSet.challenge;


public class SubarrayProducts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3};
		
		System.out.println(sub(arr,7));
	}
	public static int sub(int[]arr,int k) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			int product=1;
			for(int j=0;i+j<arr.length;j++) {
				product*=arr[i+j];
				if(product<k) {
					count++;
				}else {
					break;
				}
			}
		}
		return count;
	}
	
}

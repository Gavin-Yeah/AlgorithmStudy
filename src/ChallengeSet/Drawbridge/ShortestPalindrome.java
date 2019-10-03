package ChallengeSet.Drawbridge;

public class ShortestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="abdcddddsa";
		System.out.println(shortestPalindrome(a));
	}
	public static int shortestPalindrome(String s) {
		if(s.length()<=2||s==null)return 0;
		char[] arr=s.toCharArray();
		int min=arr.length*2;
		for(int i=0;i<arr.length;i++) {
			int m=i, n=i;
			int count=0;
			while(m>=0&&n<arr.length) {
				if(arr[m]!=arr[n]&&m-1>=0&&arr[m-1]==arr[n]) {
					count++;
					m-=2;
					n++;
				}
				else if(arr[m]!=arr[n]&&n+1<arr.length&&arr[m]==arr[n+1]){
					count++;
					n+=2;
					m--;
				}else if(arr[m]!=arr[n]){
					count+=2;
					m--;
					n++;
					
				}else {
					m--;
					n++;
				}
			}
			count+=(m+1+arr.length-n);
			if(min>count) {
				min=count;
			}
			m=i;n=i+1;
			count=0;
			while(m>=0&&n<arr.length) {
				if(arr[m]!=arr[n]&&m-1>=0&&arr[m-1]==arr[n]) {
					count++;
					m-=2;
					n++;
				}
				else if(arr[m]!=arr[n]&&n+1<arr.length&&arr[m]==arr[n+1]){
					count++;
					n+=2;
					m--;
				}else if(arr[m]!=arr[n]){
					count+=2;
					m--;
					n++;
					
				}else {
					m--;
					n++;
				}
			}
			count+=(m+1+arr.length-n);
			if(min>count) {
				min=count;
			}
			
			
		}
		return min;
	}
}

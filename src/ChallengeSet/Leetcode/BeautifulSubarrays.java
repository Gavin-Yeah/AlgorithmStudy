package ChallengeSet.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class BeautifulSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {2,5,4,9};
		System.out.println(bsa(arr,0));
	}
public static int bsa(int[] arr, int m) {
	if(m==0)return (int) Math.pow(2, arr.length);
	
	int even=0;
	Queue<Integer> prev= new LinkedList<>();
	int odd=0;
	int sum=0;
	for(int i=0;i<arr.length;i++) {
		if(arr[i]%2==0) {
			even++;
		}else {
			if(odd<=m) {
				odd++;
			}
			prev.offer(even);
			even=0;
			if(odd==m+1) {
				int count=0;
				for(Integer a:prev) {
					count+=a;
				}
				sum+=Math.pow(2,count);
				prev.poll();
			}
		
		
		}
		if(i==arr.length-1) {
			int count=0;
			for(Integer a:prev) {
				count+=a;
			}
			sum+=Math.pow(2,count);
		}
	
		
	}
	return sum;
}
}

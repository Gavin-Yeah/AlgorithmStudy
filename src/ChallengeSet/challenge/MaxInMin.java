package ChallengeSet.challenge;

import java.util.Deque;
import java.util.LinkedList;

public class MaxInMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= null;
		System.out.println(max(arr,3));
	}
	public static int max(int[]arr,int k) {
	if(arr==null||arr.length==0)return 0;
		int max=0;
		Deque<Integer> q= new LinkedList<Integer>();
	
		for(int i=0;i<arr.length;i++) {
			if(i>=k&&q.peek()<=i-k) {
				q.poll();
			}
			while(!q.isEmpty()&&arr[i]<arr[q.peekLast()]) {
				q.pollLast();
			}
			q.offer(i);
			if(i>=k-1) {
				if(max<=arr[q.peek()])max=arr[q.peek()];
			}
		}
		return max;
	}

}

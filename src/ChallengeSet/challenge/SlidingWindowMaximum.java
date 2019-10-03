package ChallengeSet.challenge;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int[] slide(int nums[], int k) {
		int res[]= new int[nums.length-k+1];
		if(nums==null||nums.length==0)return new int[0];
		Deque<Integer> window= new LinkedList<>();
		for(int i=0;i<nums.length;i++) {
			if(k>=i&&window.peek()<=i-k) {
				window.poll();
			}
			while(!window.isEmpty()&&nums[window.peekLast()]<=nums[i]) {
				window.pollLast();
			}
			window.offer(i);
			if(i>=k-1) {
				res[i-k+1]=nums[window.peek()];
			}
		}
		return res;
	}

}

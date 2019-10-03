package ChallengeSet.Drawbridge;

import java.util.Arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class countOnes {

	public static int count1(int n) {
		int count=0;
		while(n>0) {
			if((n&1)==1){
				count++;
			}
			n>>=1;
		}
		return count;
	}
	public static int[] func(int[]a) {
		Queue<Integer> heap;
		heap = new PriorityQueue<>(a.length,(Integer i,Integer j)->count1(i)==count1(j)?i-j:count1(i)-count1(j));
	//	heap=new PriorityQueue<>(a.length,(Integer i,Integer j)->count1(i)-count1(j));
		for(int i=0;i<a.length;i++) {
			heap.add(a[i]);
		}
		int[]res=new int[a.length];
		for(int i=0;i<a.length;i++) {
			res[i]=heap.poll();
		}
		return res;
	}
	public static void main(String[] args) {
		int[]arr= {5,3,4};
		System.out.println(Arrays.toString(func(arr)));
	}
}

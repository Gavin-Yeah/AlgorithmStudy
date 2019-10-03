package ChallengeSet.challenge;

import java.util.HashMap;

public class MaxSizeSubarraySumEqualsK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[]num= {1,-1,5,-2,3};
			System.out.println(max(num,3));
	}
	public static int max(int[]arr,int k) {
		int sum=0, max=0;
		HashMap<Integer,Integer> map= new HashMap<>();//sum of range,range
		map.put(0, -1); 
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			if(map.containsKey(sum-k))
				max=Math.max(max, i-map.get(sum-k));
			if(!map.containsKey(sum))map.put(sum, i);
		}
		return max;
	}

}

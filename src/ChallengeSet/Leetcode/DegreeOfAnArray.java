package ChallengeSet.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class DegreeOfAnArray {
/**
 * leetcode697 servicetitan
 * Given a non-empty array of non-negative integers nums, the degree of this array is
 *  defined as the maximum frequency of any one of its elements.
 *  Your task is to find the smallest possible length of a (contiguous) subarray of nums, 
 *  that has the same degree as nums.
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findShortestSubArray(int[] nums) {
		 int max=0;
			int dis=0;
			int min=Integer.MAX_VALUE;
			ArrayList<Integer> maxkey=new ArrayList<>();
	        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
	        for(int i=0;i<nums.length;i++){
	        	ArrayList list= map.getOrDefault(nums[i],new ArrayList<Integer>());
	        	list.add(i);
	        	map.put(nums[i],list);
	        	if(list.size()>=max) {
	        		max=list.size();
	        	}  
	        }
	        for(int i=0;i<nums.length;i++){
	        	ArrayList list= map.get(nums[i]);
	        	if(list.size()==max) {
	        		dis=(int)list.get(list.size()-1)-(int)list.get(0)+1;
	        		if(dis<min) {
	        			min=dis;
	        		}
	        	}
	        }
	        return min;
        
    }
}

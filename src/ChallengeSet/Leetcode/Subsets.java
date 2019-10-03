package ChallengeSet.Leetcode;

import java.util.LinkedList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * leetcode 78
	 * Given a set of distinct integers, nums, return all possible subsets (the power set).
	 * @param nums
	 * @return
	 */
	  public List<List<Integer>> subsets(int[] nums) {
	         List<List<Integer>> res = new LinkedList<List<Integer>>();
	        if (nums == null || nums.length == 0) {
	            return res;
	        }
	        List<Integer> temp = new LinkedList<Integer>();
	        findSubsets(nums, 0, temp, res);
	        return res;
	    }
	    public void findSubsets(int []nums, int index, List<Integer>temp,List<List<Integer>>res){
	         if (index == nums.length) {
	            res.add(new LinkedList<Integer>(temp));
	            return;
	        }
	        temp.add(nums[index]);
	       findSubsets(nums, index + 1, temp, res);
	        temp.remove(temp.size() - 1);
	        findSubsets(nums, index + 1, temp, res);
	    }
}

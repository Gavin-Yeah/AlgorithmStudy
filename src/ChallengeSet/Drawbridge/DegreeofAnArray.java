package ChallengeSet.Drawbridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Given a non-empty array of non-negative integers nums, 
 * the degree of this array is defined as the maximum frequency of 
 * any one of its elements.
 * Your task is to find the smallest possible length of a 
 * (contiguous) subarray of nums, that has the same degree as nums.
 * @author jiadaye
 *
 */
public class DegreeofAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list= new ArrayList<>();
		list.add(2);
		list.add(5);
		list.add(8);
		System.out.println(findShortestSubArray(list));
	}
	 public static int findShortestSubArray(List<Integer> nums) {
	        Map<Integer, Integer> left = new HashMap(),
	            right = new HashMap(), count = new HashMap();

	        for (int i = 0; i < nums.size(); i++) {
	            int x = nums.get(i);
	            if (left.get(x) == null) left.put(x, i);
	            right.put(x, i);
	            count.put(x, count.getOrDefault(x, 0) + 1);
	        }

	        int ans = nums.size();
	        int degree = Collections.max(count.values());
	        for (int x: count.keySet()) {
	            if (count.get(x) == degree) {
	                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
	            }
	        }
	        return ans;
	    }
}

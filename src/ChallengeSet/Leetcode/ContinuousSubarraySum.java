package ChallengeSet.Leetcode;

import java.util.HashMap;

public class ContinuousSubarraySum {
	public static void main(String[] args) {
		int num[]= {23,2,6,4,7};
		System.out.println(checkSubarraySum(num,6));
	}
	/**
	 * leetcode 523 servicetitan
	 * Given a list of non-negative numbers and a target integer k, 
	 * write a function to check if the array has a continuous subarray of size at 
	 * least 2 that sums up to the multiple of k, 
	 * that is, sums up to n*k where n is also an integer.
	 * @param nums
	 * @param k
	 * @return
	 */
	public static boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<2) return false;
        if(k==0){
           for(int i=0;i<nums.length-2;i++){
           if(nums[i]==0&&nums[i+1]==0)return true;
           }
            return false;
        }
        if(k==1)return true; 
        HashMap <Integer,Integer>map= new HashMap<>();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int mod=sum%k;
            if(map.get(mod)==null){
                 map.put(mod,i);
            }         
            else{
                if(i-map.get(mod)>1) return true;
              
            }
            
        }
        return false;
    }
}

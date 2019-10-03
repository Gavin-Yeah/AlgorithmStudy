package BinarySearch;

public class BinarySearch {

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
         
         
         /*
          *  int lo = 0;
    int hi = nums.length - 1;

    while(lo <= hi)
    {
    	int mid = (lo + hi) >>> 1;

    	if(nums[mid] < target)
    		lo = mid + 1;
    	else if(nums[mid] > target)
    		hi = mid - 1;
    	else
    		return mid;
    }

    return -1;
          */
    }


    private int binarySearch(int[] nums, int start, int end, int target) {

        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (nums[mid] == target)
            return mid;

        if (nums[mid] < target)
            return binarySearch(nums, mid + 1, end, target);
        else
            return binarySearch(nums, start, mid - 1, target);


    }
}

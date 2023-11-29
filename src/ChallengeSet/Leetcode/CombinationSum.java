package ChallengeSet.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// import java.util.HashMap;
public class CombinationSum {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> CombinationSum(int[] candidates, int target) {
        boolean flag = true;
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        while (flag) {
            for (int i = 0; i < candidates.length; i++) {
                Set<Integer> set = map.keySet();
                for (Integer j : set) {
                    Integer sum = j + candidates[i];
                    if(sum<=target){
                       List<List<Integer>> list =  map.getOrDefault(sum, new ArrayList<List<Integer>>());
                    }
                }
            }
        }
        return null;

    }
}

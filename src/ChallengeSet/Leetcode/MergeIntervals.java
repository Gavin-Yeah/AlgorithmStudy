package ChallengeSet.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	   public static List<Interval> merge(List<Interval> intervals) {
	       List<Interval> list =new ArrayList<>();
	     if(intervals.size()<=1)return intervals;
	        Collections.sort(intervals,(i1,i2)->Integer.compare(i1.start,i2.start));
	       Interval cur=intervals.get(0);
	       for(Interval nextInterval:intervals){
	           if(cur.end<nextInterval.start){
	               list.add(cur);
	               cur=nextInterval;
	           }
	           else{
	               cur.end=Math.max(nextInterval.end,cur.end);
	           }
	       }
	        list.add(cur);															
	        return list;
	    }
	   
}
class Interval{
	int end;
	int start;
}
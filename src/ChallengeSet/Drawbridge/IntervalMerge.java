package ChallengeSet.Drawbridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给一个含n个区间list，合并所有有交集的区间。
 * @author jiadaye
 *
 */
public class IntervalMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static List<Interval> merge(List<Interval> l){
		List<Interval> ret = new ArrayList<>();
		if(l.size()==0||l==null) return ret;
		Collections.sort(l,(a,b)->a.start==b.start?a.end-b.end:a.start-b.start);
		Interval pre=l.get(0);
		for(int i=1;i<l.size();i++) {
			Interval cur=l.get(i);
			if(cur.start>pre.end) {
				ret.add(pre);
				pre=cur;
			}else {
				pre=new Interval(pre.start,Math.max(pre.end, cur.end));
			}
		}
		ret.add(pre);
		return ret;
		
	}
	
}
class Interval{
	int start;
	int end;
	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
}
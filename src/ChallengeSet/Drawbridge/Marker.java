package ChallengeSet.Drawbridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Marker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>l= new ArrayList<>();
		
		l.add(6);
		l.add(1);
		l.add(19);
		l.add(21);
		l.add(15);
		l.add(17);
		l.add(18);
		System.out.println(marker(l));
	}
public static int marker(List<Integer> l) {
	if(l.size()==1)return l.get(0);
	HashMap<Integer,Integer> map= new HashMap<>();
	int max=0;
	for(int i=0;i<l.size()-1;i++) {
		int right=Math.max(l.get(i), l.get(i+1));
		int left=Math.min(l.get(i),l.get(i+1));
		while(left<=right) {
			int count=map.getOrDefault(left, 0);
			count++;
			if(max<count)max=count;
			map.put(left, count);
			left++;
		}
		
	}
	Collections.sort(l);
	for(int i=0;i<l.size();i++) {
		if(map.get(l.get(i))==max) {
			return l.get(i);
		}
	}
	return 0;
}
}

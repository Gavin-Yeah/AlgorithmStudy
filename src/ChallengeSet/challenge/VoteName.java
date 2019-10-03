package ChallengeSet.challenge;

import java.util.HashMap;
import java.util.Map.Entry;

public class VoteName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String[]names= {"Alex","Michael","Harry","Dave","Michael","Victory","Harry",
		"Alex","Mary","Mary"};
System.out.println(win(names));
}
	
	public static String win(String[] names) {
		HashMap<String, Integer> map=new HashMap<>();
		String ret="";
		int max=0;
		for(int i=0;i<names.length;i++) {
			
			map.put(names[i], map.getOrDefault(names[i], 0)+1);
			if(map.get(names[i])>max) {
				max= map.get(names[i]);
				
			}
		}
		//System.out.println(max);
		for(Entry<String,Integer> e : map.entrySet()) {
			if(e.getValue()==max) {
				if(e.getKey().compareTo(ret)>0) {
					ret=e.getKey();
				}
			}
		}
		return ret;
	}
}

package ChallengeSet.phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class DicToStirng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dic b= new dic();
		b.put("b", "blueberry");
		b.put("c", "cranberry");
		dic a= new dic();
		a.put("a","apple");
		a.put("b",b );
		a.put("c","colo" );
		String str=a.toString();
		System.out.println(str);
		System.out.println(cut(str).toString());
		List<String>l=cut(str);
		System.out.println(l.get(1));
		
		dic d=put(str);
		System.out.println(d.toString());
		
	}
	public static dic put(String str) {
		dic d=new dic();
		List<String> l=cut(str);
		for(int i=0;i<l.size();i++) {
			String s=l.get(i);
		
			String[] entry= s.split(":", 2);
			if(entry[1].contains("{")) {
				dic d2=put(entry[1]);
				d.put(entry[0], d2);
			}else {
				d.put(entry[0], entry[1]);
				
			}
				
		}
		return d;
	}
	public static List<String> cut(String str) {
		int count=0;
		int cur=1;
		ArrayList<String> l= new ArrayList<>();
		for(int i=0;i<str.length();i++) {
			if(count==1) {
			if(str.charAt(i)==',') {
				l.add(str.substring(cur,i));
				cur=i+1;
			}
			}
			if(str.charAt(i)=='{') {
				count++;
			}else if(str.charAt(i)=='}') {
				count--;
			}
		}
		l.add(str.substring(cur,str.length()-1));
		return l;
		
	}

}
class dic{
	HashMap<String, Object> map;
	
	public dic() {
		map=new HashMap<>();
		
		// TODO Auto-generated constructor stub
	}
	public void put(String key,Object value) {
		map.put(key, value);
	}
	
	public boolean hasNext() {
		return map.isEmpty();
	}
	public Object get(String key) {
		return map.get(key);
	}
	public Object remove(String key) {
		return map.remove(key);
	}
	public String toString() {
		StringBuilder ret= new StringBuilder();
		ret.append("{");
		for(Entry<String,Object> entry:map.entrySet()) {
			
			ret.append(entry.getKey()).append(":");
			if(entry.getValue() instanceof dic) {
				ret.append(entry.getValue().toString()).append(",");
			}else {
				ret.append(entry.getValue()).append(",");
			}
				
		
		}
		ret.deleteCharAt(ret.length()-1);
		ret.append("}");
		return ret.toString();
	}
	
}
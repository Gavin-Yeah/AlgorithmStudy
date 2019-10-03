package ChallengeSet.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abab";
		String p="ab";
		List<Integer> list=findAnagrams(s, p);
		System.out.println(list.toString());
	}
	  public static List<Integer> findAnagrams(String s, String p) {
		  if(s==null||s.length()==0) return new ArrayList<Integer>();
		   List<Character> letters= new LinkedList<>();
		   List<Integer> index= new ArrayList<>();
	        for(int i=0;i<p.length();i++){
	            letters.add(p.charAt(i));
	        }
	      search:  for(int i=0;i<s.length()-p.length()+1;i++){
	        	 List<Character> temp=new LinkedList<>(letters); 
	        	 int a=0;
	        	while(temp.size()>0) {
	        		if(temp.contains(s.charAt(i+a))) {
	        			for(int m=0;m<temp.size();m++) {
	        				if(temp.get(m).equals(s.charAt(i+a))) {
	        					temp.remove(m);
	        					
	        					a++;
	        					break;
	        				}
	        			}
	        		
	        		}else {
	        			continue search;
	        		}	
	        	}
	        	if(temp.size()==0) {
	        		index.add(i);
	        		
	        	}
	        }
	        return index;
	    }
}

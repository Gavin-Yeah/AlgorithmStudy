package ChallengeSet.challenge;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RoyalName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(royal(new String[] {"Arry IX","Louis VIII"})));
	}
	public static String[] royal(String[] names) {
		Arrays.sort(names, new StringComp());
		return names;
	}
	
}
class StringComp implements java.util.Comparator<String>{
	

	@Override
	public int compare(String o1, String o2) {
		String[] a=o1.split(" ");
		String[] b=o2.split(" ");
		if(a[0].compareTo(b[0])!=0) {
			return a[0].compareTo(b[0]);
		}
		int num1=RomanToInteger(a[1]);
		int num2=RomanToInteger(b[1]);
		return num1-num2;
		
		
	}
	public static int RomanToInteger(String s) {
		 int num=0;
	        Map <Character,Integer> map= new HashMap<>();
	        map.put('I',1);
	        map.put('V',5);
	        map.put('X',10);
	        map.put('L',50);
	       
	        int i=s.length()-1;
	        num+=map.get(s.charAt(i--));
	        for(;i>=0;i--){
	          if(s.charAt(i)=='I'&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X'))  {
	              num-=map.get(s.charAt(i));
	          }
	         else   if(s.charAt(i)=='X'&&(s.charAt(i+1)=='L'))  {
	              num-=map.get(s.charAt(i));
	          }
	         
	            else  num+=map.get(s.charAt(i));
	        }
	        return num;
	}
	
}

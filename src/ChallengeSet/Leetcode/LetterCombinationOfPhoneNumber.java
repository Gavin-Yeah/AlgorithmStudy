package ChallengeSet.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String a="23";
List<String> list= letterCombinations(a);
System.out.println(list.toString());

	}
	public static List<String> letterCombinations(String digits) {
		String letters[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		List<String>list=new ArrayList<>();
		if(digits.length()==0||digits==null)return list;
		for(int i=0;i<letters[digits.charAt(0)-'0'].length();i++) {
			list.add(String.valueOf(letters[digits.charAt(0)-'0'].charAt(i)));
		}
		for(int i=1;i<digits.length();i++) {
			
			
			int index=digits.charAt(i)-'0';
			String letter=letters[index];
			list=update(list,letter);
		}
		return list;
	}
	private static List<String> append(List<String> list, String end){
		List<String>b=new ArrayList<>(list);
		for(int i=0;i<b.size();i++) {
			b.set(i, b.get(i)+end);
		}
		return b;
		
		
	}
	private static List<String> update(List<String>a,String letter){
		List<String> ret=new ArrayList<>();
		for(int i=0;i<letter.length();i++) {
			List<String> tmp= append(a,String.valueOf(letter.charAt(i)));
			ret.addAll(tmp);
		}
	return ret;
		
	}
	
}

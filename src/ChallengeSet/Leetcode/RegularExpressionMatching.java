package ChallengeSet.Leetcode;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String a="aaaaaaabcd";
String b="a*bcd";

System.out.println(isMatch(a,b));
	}
	public static boolean isMatch(String s, String p) {
		if(p.isEmpty())	return s.isEmpty();
		if(p.length()==1) 	return s.equals(p)||(s.length()==1&&p.equals("."));
		if(p.charAt(1)!='*') {
			if(s.isEmpty()) return false;
			return (s.charAt(0)==p.charAt(0)||p.charAt(0)=='.')&& isMatch(s.substring(1),p.substring(1));
		}
		while(!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.')){
			 if (isMatch(s, p.substring(2))) return true;
	            s = s.substring(1);
		}
		return isMatch(s, p.substring(2));
	}
}

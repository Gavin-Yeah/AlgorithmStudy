package ChallengeSet.Leetcode;

public class Strstr {
	
	public static void main(String[] args) {
		String a="hello";
		String b="ll";
		System.out.println(strStr(a,b));
	}
	 public static int strStr(String haystack, String needle) {
	        if(!haystack.contains(needle)) return -1;
	       return haystack.indexOf(needle);
	    }
}

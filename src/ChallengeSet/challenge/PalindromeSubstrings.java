package ChallengeSet.challenge;

import java.util.HashSet;
import java.util.Set;

public class PalindromeSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Palindrome("aabaa"));
	}
	public static int Palindrome(String str) {
		if(str==null||str.length()==0)return 0;
		Set<String> set= new HashSet<>();
		for(int i=0;i<str.length();i++) {
			int j=0;
			while(i+j<str.length()&&i-j>=0) {
				if(str.charAt(i+j)==str.charAt(i-j)) {
					set.add(str.substring(i-j,i+j+1));
					j++;
					
				}else {
					break;
				}
			}
			j=0;
			while(i+j+1<str.length()&&i-j>=0) {
				if(str.charAt(i+j+1)==str.charAt(i-j)) {
					set.add(str.substring(i-j,i+j+2));
					j++;
					
				}else {
					break;
				}
			}
		}
		return set.size();
	}
}

package ChallengeSet.phone;

import java.util.Dictionary;

public class StringPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb";
		
		String p= "***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**";
		System.out.println(pattern(str,p));
	}
	public static boolean pattern(String str, String p) {
		p=p.replace("**", "*");
		p=p.replace("*", ".*");
		
//	for(int i=0;i<str.length();i++) {
//		for(int j=i+1;j<=str.length();j++) {
//			if(str.substring(i, j).matches(p)) {
//				return true;
//			}
//		}
//	}
		if(str.matches(p)) {
			return true;
		}
		
		return false;
	}


}

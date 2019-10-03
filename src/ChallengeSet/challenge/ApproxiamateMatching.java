package ChallengeSet.challenge;

public class ApproxiamateMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(match("nothing","bruno","ingenious"));
	}
	public static int match(String sub, String pre, String suf) {
		int presco=0, sufsco=0;
		tag1:for(int i=0;i<Math.min(pre.length(),sub.length());i++) {
			for(int m=0;m<=i;m++) {
				if(pre.charAt(pre.length()-i-1+m)!=sub.charAt(m)) {
					continue tag1;
				}
			}
			presco=i+1;
			
		}
		
		tag2:for(int i=0;i<Math.min(suf.length(),sub.length());i++) {
			for(int m=0;m<=i;m++) {
				if(suf.charAt(m)!=sub.charAt(sub.length()-i-1+m)) {
					continue tag2;
				}
			}
			sufsco=i+1;
			
		}
		return presco+sufsco;
	}

}

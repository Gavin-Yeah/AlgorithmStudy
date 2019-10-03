package ChallengeSet.challenge;

public class AcmeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(acme("ihaveadog","e***g"));
	}
	public static int acme(String a, String b) {
		
		tag:for(int i=0;i<a.length();i++) {
			int s=i;
			
			for(int m=0;m<b.length();m++) {
				if(b.charAt(m)=='*'||b.charAt(m)==a.charAt(m+i)) {
					
				}else {
					continue tag;
				}
			}
			return s;
			
			
		}
	return -1;
	}

}

package ChallengeSet.challenge;

public class ReachingPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(dfs(1,4,5,4));
	}
	public static boolean dfs(int a, int b, int c, int d) {
		if(a==c&&b==d)return true;
		else if(c<a||d<b) return false;
		else return dfs(a,b,c-d,d)|| dfs(a,b,c,d-c);
		
	}

}

package ChallengeSet.Leetcode;

public class IJMove {
/**
 * servicetitan 
 * only possible moves from (i,j) are
 * (i+j,j) (i,i+j) (i-j,j) (i,j-i)
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int gcd(int i, int j) {
		if(i>j) {
			return gcd(i-j,j);
		}
		if(j>i) {
			return gcd(i,j-i);
		}
		else return i;
	}
	public static boolean isPossible(int x, int y, int a, int b) {
		x=Math.abs(x);
		y=Math.abs(y);
		a=Math.abs(a);
		b=Math.abs(b);
		return gcd(x,y)==gcd(a,b);
		
		
	}
}

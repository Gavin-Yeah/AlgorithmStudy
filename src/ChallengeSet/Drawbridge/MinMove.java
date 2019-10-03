package ChallengeSet.Drawbridge;

import java.util.Arrays;

/**
 * 两个整数数组a，b，最少步数使a中的数变为b中的数
 * @author jiadaye
 *
 */
public class MinMove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minMove(4321,1234));
	}
	public int MinMove(int[]a,int[]b) {
		Arrays.sort(a);
		Arrays.sort(b);
		int count=0;
		for(int i=0;i<a.length;i++) {
			
				count+=Math.abs(b[i]-a[i]);
			
		}
		return count;
	}
	public static int minMove(int a, int b) {
		int count=0;
		while(a!=0) {
			count+=Math.abs(a%10-b%10);
			a/=10;
			b/=10;
		}
		return count;
	}

}

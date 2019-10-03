package ChallengeSet.Drawbridge;
/**
 * 找到<n的互质数总数
 * @author jiadaye
 *
 */
public class Euler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {5,8,14};
		int[] a=func(arr);
		for(int i:a) {
			System.out.println(i);
		}
	}
	public static int[] func(int[] arr) {
		int [] ret= new int[arr.length];
		for(int i=0;i<ret.length;i++) {
			ret[i]=euler(arr[i]);
		}
		return ret;
	}
	public static int euler(int n) {
		
	
		for(int i=2;i<=n;i++) {
			if(n%i==0&&(n/i)%i==0) {
				return euler(n/i)*i;
			}else if(n%i==0&&(n/i)%i!=0) {
				return euler(n/i)*(i-1);
			}
		}
		return 1;
	}
}

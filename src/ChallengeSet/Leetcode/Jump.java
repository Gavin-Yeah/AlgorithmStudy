package ChallengeSet.Leetcode;

public class Jump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []start= {100,2};
		int []end= {3,4};
		System.out.println(jump(start,end));
	}
	public static int jump(int [] start, int [] end) {
		int xs=start[0];
		int xe=end[0];
		int ys=start[1];
		int ye=end[1];
		int count=0;
		int xd=Math.abs(xe-xs);
		int yd=Math.abs(ye-ys);
		while(yd!=0||xd!=0) {
			if(Math.abs(yd)==1&&Math.abs(xd)==2) {
				 return count+1;
				}
				if(Math.abs(xd)==1&&Math.abs(yd)==2) {
					 return count+1;
					}
			if(xd>yd) {
				yd=Math.abs(yd-1);
				xd=Math.abs(xd-2);
				count++;
			}else if(xd<yd){
				yd=Math.abs(yd-2);
				xd=Math.abs(xd-1);
				   int m=(int)Math.sqrt(23);
				count++;
				
			}else {
				if(xd>=3) {
					count+=(xd/3)*2;
					xd-=3*(xd/3);
					yd=xd;
				}
				if(xd==2) {
					return count+3;
				}
				if(xd==1) {
					return count+2;
				}
			}
			
		}
		return count;
		
	}
	 public static int consecutiveNumbersSum(int N) {
	       int ans = 0;
	       // int m=(int)Math.sqrt(2N);
	        for (int k = 1; k <= 2N; k++){
	                if((N-(k*k+k)/2)%k==0){
	                    ans++;
	                }
	            }
	        return ans;
	    }
}

package ChallengeSet.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class RemoveChocolate {
/*
 * 给定n个巧克力 每次remove 1或3个，问有几种方法
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(remove(57));
	}
	public static long remove(int chocolate) {
	long []count=new long[1];
	rm(chocolate,count);
	return  count[0];
	}
	public static void rm(int chocolate, long[] count) {
	
		if(chocolate==0) count[0]++;
		if(chocolate-3>=0) {
			rm(chocolate-3,count);	
		}
		if(chocolate>=1) {
			rm(chocolate-1,count);
		
		}
		
	}
//	public static int remove2(int chocolate) {
//		int [] count=new int[chocolate];
//		for(int i=1;i<chocolate;i++) {
//			count[i]=
//		}
//	}
	public static long remove2(int chocolate) {
		int count[]= new int[chocolate+1];
		count[chocolate]=0;
		int c=0;
		while(chocolate>=0) {
			if(chocolate>=1) {
			count[chocolate-1]=count[chocolate]+1;
			c++;
			}
			if(chocolate>=3) {
			count[chocolate-3]=count[chocolate]+1+count[chocolate-1];
			c++;
			}
			chocolate--;
		}
		return c;	
	} 
	public static int cut(int n,int []r)
    {
        int q=-1;
        if(r[0]>0)
            return r[0];
        if(n==0)
            q=0;
        else {
            for(int i=n;i>0;i--)
                q=cut(n-i,r);
        }
        r[n]=q;

        return q;
    }


}

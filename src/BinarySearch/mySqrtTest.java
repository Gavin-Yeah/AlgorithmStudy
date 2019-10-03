package BinarySearch;

public class mySqrtTest {
	public static void main(String[] args) {
		System.out.println(mySqrt(9));
	}
	//use the binary search to fins the square root
	public static int mySqrt(int x) {
	        if(x==0)return 0;
	        int low=1;
	        int hi=x/2+1;
	       
	            
	        while(low+1<hi){
	            int mid=(low+hi)/2;
	            if(mid>x/mid){
	                hi=mid;
	            }
	            else if(mid<x/mid){
	                low=mid;
	            }
	            else{
	                return mid;
	            }
	        }
	        return low;
	        
	    }
}

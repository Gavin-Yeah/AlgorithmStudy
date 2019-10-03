package ChallengeSet.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class GCD
{
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public static int generalizedGCD(int arr[])
  {
	  if(arr==null||arr.length==0)return 0;
      int min=arr[0];
    // INSERT YOUR CODE HERE
    for(int i=0;i<arr.length;i++){
        if(min>arr[i])min=arr[i];
    }
    List<Integer>list= new ArrayList<>();
    for(int i=2;i<=min;i++) {
    	if(min%i==0) {
    		list.add(i);
    	}
    }
    if(min==0)return 0;
    if(min==1)return 1;
   search: for(int i=0;i<=list.size();i++){
        for(int j=0;j<arr.length;j++){
            if(arr[j]%list.get(i)!=0){
               continue search;
            }
        }
        return list.get(i);
    }
    return 1;

  }
  
  private static int gcd(int num1, int num2) {
      if (num1 == 0 || num2 == 0) return 0;
      while (num1 != 0 && num2 != 0) {
          if (num2 > num1) {
              num1 ^= num2;
              num2 ^= num1;
              num1 ^= num2;
          }
          int temp = num1 % num2;
          num1 = num2;
          num2 = temp;
      }
      return num1 + num2;
  }
  public static int generalizedGCD1(int arr[])
  {
    // INSERT YOUR CODE HERE
 if (arr == null || arr.length == 0) return 0;
        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            gcd = GCD_base(gcd, arr[i]);
        }
        return gcd;
  }
  
  public static int  GCD_base(int a,int b)
  {
      int r;
      while(b>0)
      {
           r=a%b;
           a=b;
           b=r;
      }
      return a;
  }

  // METHOD SIGNATURE ENDS
  public static void main(String[] args) {
	int []arr= {1231,2462,3693,2444};
	System.out.println(generalizedGCD1(arr));
	System.out.println(GCD_base(194,56));
	System.out.println(gcd(194,56));
}
}
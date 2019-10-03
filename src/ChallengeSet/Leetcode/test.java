package ChallengeSet.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String[] args) {
		System.out.println(Factorize(100).toString());
	}
	 public static List<Integer> Factorize(long number)
     {   ArrayList<Integer>list = new ArrayList<>();
         helper(number,list);
         return list;
         
         
     }
         
     
     public static void helper(long number,ArrayList<Integer> list){
         if(number==1){
             return;
             }
         for(int i=2;i<=number;i++){
         if(number%i==0){
             list.add(i);
             helper(number/i,list);
             break;
         }
     }
}
}

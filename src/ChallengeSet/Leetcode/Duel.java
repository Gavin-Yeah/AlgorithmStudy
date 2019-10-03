package ChallengeSet.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Duel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list =new ArrayList<>();
		list.add(-2);
		list.add(5);
		list.add(-8);
		list.add(20);
		list.add(-13);
		System.out.println(duel(list));
	}
	public static int duel(List<Integer> num) {
		int sum=0;
		int min=Integer.MAX_VALUE;
		for(Integer action:num) {
			sum+=action;
			if(sum<min) {
				min=sum;
			}
		}
		if(min<0) {
			return -min+1;
		}
		return 0;
	}
}

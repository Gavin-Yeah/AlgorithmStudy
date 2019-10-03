package ChallengeSet.Leetcode;

import java.util.HashMap;

public class MovieRating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]= {9,-1,-3,4,5};
		System.out.println(rate(num));
	}
	public static int rate(int num[]) {
	
	int take=0,skip=0;
	for(int i=0;i<num.length;i++) {
	
		int takei=Math.max(skip+num[i], take+num[i]);  //如果我们拿了当前的数字，那么对于前面的数字我们既可以拿也可以不拿，
		//于是当前的积分就是拿前面的数字的积分和不拿前面数字的积分中的较大值。
		int skipi=take;//如果我们不拿当前的数字，那么对于前面的数字我们必须拿，
				//于是当前的积分就是拿前面的数字的积分。
		skip=skipi;
		take=takei;
		

	}
	return Math.max(skip, take);
	}
}

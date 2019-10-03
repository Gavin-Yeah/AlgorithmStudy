package ChallengeSet.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JungleBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []animals= {-1,0,1};
		System.out.println(maxDistance(animals));
		
		

	}
	public static int maxDistance(int[] animals) {

	int max=0;
		for(int i=0;i<animals.length;i++) {
		ArrayList<Integer> predators=new ArrayList<>();
		int pre=animals[i];
		while(pre!=-1) {
			predators.add(pre);
			pre=animals[pre];
		}
		 max=Math.max(predators.size(),max);
		}
		
		return max;
		
	}
}

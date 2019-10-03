package ChallengeSet.challenge;

import java.util.Arrays;

public class Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(square(new int[] {0,2,7},new int[] {0,4,9}, 2));
	}
	public static int  square(int[]x, int[]y,int k) {
		int min=Integer.MAX_VALUE;
		int[][]co= new int[x.length][2];
		for(int i=0;i<x.length;i++) {
			co[i][0]=x[i];
			co[i][1]=y[i];
		}
		Arrays.sort(co,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
		for(int i=0;i<=x.length-k;i++) {
			int xRange=co[i+k-1][0]-co[i][0];
			int yRange=co[i+k-1][1]-co[i][1];
			int side=Math.max(xRange, yRange)+1;
			int area=side*side;
			if(min>area)min=area;
		}
		return min;
	}
}

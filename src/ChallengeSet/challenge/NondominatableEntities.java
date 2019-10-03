package ChallengeSet.challenge;

import java.util.ArrayList;

public class NondominatableEntities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static ArrayList<Integer>findUndominatedPairIndexes(int[][]arrayOfPairs)
	    {
	        ArrayList<Integer>result=new ArrayList<Integer>();
	        int maxX=Integer.MIN_VALUE;
	        int maxY=Integer.MIN_VALUE;
	        int i=arrayOfPairs.length;
	        /**
	         * get the max value
	         */
	        for(;--i>=0;)
	        {
	            int x=arrayOfPairs[i][0];
	            int y=arrayOfPairs[i][1];
	            if (x>maxX)
	            {
	                maxX=x;
	            }
	            if (y>maxY)
	            {
	                maxY=y;
	            }
	        }
	        for(i=arrayOfPairs.length;--i>=0;)
	        {
	            int[] pair=arrayOfPairs[i];
	            if (pair[0]>=maxX||pair[1]>=maxY)
	            {
	                result.add(new Integer(i));
	            }

	        }
	        return result;
	    }
}

package ChallengeSet.Leetcode;

public class DrawingEdges {
/**
 * drawing edges
 * given n vertices, how many edge sets
 * servicetitan
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(drawEdge(2));
	}
	public static long drawEdge(int n) {
		long sum=0;
		
		if(n==0||n==1)return 0;
		long edges=2;
		for(int i=0;i<n;i++) {
			sum+=i;
		}
		for(int i=1;i<sum;i++) {
			edges*=2;
			edges=edges%((long)Math.pow(10, 9)+7);
		}
		return edges;
	}

}

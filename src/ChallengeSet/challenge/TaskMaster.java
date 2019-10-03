package ChallengeSet.challenge;

import java.util.Arrays;

public class TaskMaster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(master(5,new int[] {2,1},new int[] {1,2}));
	}
	public static int master(int t, int[]a, int[]b) {
		int [] tasks= new int[t+1];
		int count=0;
		 Arrays.fill(tasks, 1);
		for(int i=0;i<b.length;i++) {
			if(tasks[a[i]]==1) {
				
				tasks[b[i]]=0;
				count++;
			}else {
				if(tasks[b[i]]==1) {
					tasks[b[i]]=2;//frozen
				}
			}
		}
		for(int i=1;i<=t;i++) {
			if(tasks[i]==1) {
				count++;
			}
		}
		return count;
	}
}

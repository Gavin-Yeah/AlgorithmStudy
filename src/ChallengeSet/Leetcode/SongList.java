package ChallengeSet.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SongList {
	public static void main(String[] args) {
		List<Integer> songs= new ArrayList<>();
		songs.add(20);
		songs.add(30);
		songs.add(90);
		songs.add(40);
		System.out.println(list(songs));
		List<Long> temp= new LinkedList<>();
		
	}
	public static long list(List<Integer> songs) {
		long count[]=new long[1];
		if(songs.size()==0||songs==null) return 0;
		List<Integer> temp= new LinkedList<>();
		findSubsets(songs,0,temp,count);
		return count[0];
		
	}
	 public static void findSubsets(List<Integer> songs, int index, List<Integer>temp,long []count){
         if (index == songs.size()) {
            if(temp.size()>=2) {
            	int sum=0;
            	for(int i=0;i<temp.size();i++) {
            		sum+=temp.get(i);
            	}
            	if(sum%60==0) {
            		count[0]++;
            	}
            }
            return;
        }
        temp.add(songs.get(index));
       findSubsets(songs, index + 1, temp, count);
        temp.remove(temp.size() - 1);
        findSubsets(songs, index + 1, temp, count);
    }
}

package ChallengeSet.Drawbridge;
import java.util.Arrays;
import java.util.TreeSet;
/**
 * {a,b}为a到b的所有连续整数
 * 包含所有集合中起码两个的的集合s
 * @author jiadaye
 *
 */
public class SetIntersectionSizeAtLeastTwo {
public static void main(String[] args) {
	int [][] intervals= {{1,2},{2,3},{2,4},{4,5}};
	System.out.println(intersectionSizeTwo(intervals));
}
public static int intersectionSizeTwo(int[][] intervals) {
	//左升序右降序
Arrays.sort(intervals,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
 int length=intervals.length;
// int e=intervals[length-1][0]+1;

//  int s=intervals[0][1]-1;
  TreeSet<Integer> l= new TreeSet<>();
task: for(int i=length-1;i>=0;i--) {
     int count=0;
     for(Integer n: l){
         if(n>=intervals[i][0]&&n<=intervals[i][1]){
          count++; 
         if(count==2){
             continue task;
         }
         }
         }
         while(count<2){
  			   l.add(intervals[i][0]+(1-count));
                 count++;        		
         }
     
 }
 return l.size();
 }
public static int intersectionSizeTwo1(int[][] intervals) {
	Arrays.sort(intervals,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
	int left=intervals[intervals.length-1][0];
	int right=intervals[intervals.length-1][0]+1;
	int res=2;
	for(int i=intervals.length-2;i>=0;i--) {
		if(intervals[i][1]>=left&&intervals[i][1]<right) {
			res++;
			right=left;
			left=intervals[i][0];
		}
		else if(intervals[i][1]<left)
		{
			res+=2;
			left=intervals[i][0];
			right=intervals[i][0]+1;
		}
		
}
	return res;
}
}


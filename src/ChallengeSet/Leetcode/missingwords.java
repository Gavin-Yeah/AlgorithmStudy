package ChallengeSet.Leetcode;

public class missingwords {
public static void main(String[] args) {
	String a="I am using HackerRank to improve programming";
	String b="am HackerRank to improve";
	String []c= miss(a,b);
	for(String s:c)
	System.out.println(s);
}
public static String[] miss(String a, String b) {
	
	String[] a1;
	String[] b1;
if(b.length()<=a.length()) {
	 a1=a.split(" ");
	 b1=b.split(" ");
	}else {
		 a1=b.split(" ");
		 b1=a.split(" ");
	}
	String [] ret=new String[a1.length-b1.length];
	int index1=0,index2=0,index3=0;
	while(index1<a1.length&&index2<b1.length) {
		if(a1[index1].equals(b1[index2])) {
			index1++;
			index2++;
		}
		else{
			ret[index3]=a1[index1];
			index3++;
			index1++;
			
		}
	}
	while(index1<a1.length) {
		ret[index3]=a1[index1];
		index1++;
		index3++;
	}
	
	return ret;
}
}

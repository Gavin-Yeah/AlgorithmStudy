package ChallengeSet.Drawbridge;

import java.util.LinkedList;
import java.util.List;

public class IntersectionTwoList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a= new LinkedList<>();
		List<Integer> b= new LinkedList<>();
		a.add(2);
		a.add(4);
		b.add(2);
		b.add(4);
		a.add(5);
		List<Integer>c=intersection(b, a);
		System.out.println(c);
	}
	public static <T> List<T>  intersection(List<T>a,List<T>b){
		a.retainAll(b);
		return a;
	}
}

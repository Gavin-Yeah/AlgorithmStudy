package ChallengeSet.Leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class code {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(300);
		list.add(5);
		list.add(5);
		list.add(5);

		list.add(5);
		list.add(5);
		List<String> list1 = new ArrayList<>();
		list1.add("dd");
		list1.add("ddd");
		list1.add("sddf");
		list1.add("sddf");
		list1.add("sddf");
		System.out.println(take(list, list1));
		System.out.println(sum1(list));
		System.out.println(sum2(list));
		System.out.println(sum3(list));
		System.out.println(FibonacciList(3));

	}

	public static int sum1(List<Integer> list) {
		if (list.isEmpty())
			return 0;
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;

	}

	public static int sum2(List<Integer> list) {
		if (list.isEmpty())
			return 0;
		int sum = 0;
		Iterator<Integer> a = list.iterator();
		while (a.hasNext()) {
			sum += a.next();
		}
		return sum;

	}

	public static int sum3(List<Integer> list) {
		if (list.isEmpty())
			return 0;
		return sum3(list, 0);

	}

	public static int sum3(List<Integer> list, int index) {
		if (index == list.size() - 1)
			return list.get(index);
		return list.get(index) + sum3(list, index + 1);
	}

	public static List take(List a, List b) {

		List<Object> ret = new ArrayList<>();
		for (int i = 0, j = 0; i < a.size() || j < b.size(); i++, j++) {
			if (i < a.size())
				ret.add(a.get(i));
			if (i < b.size())
				ret.add(b.get(j));

		}

		return ret;

	}

	public static List<Integer> FibonacciList(int num) {
		List<Integer> list = new ArrayList<>();
		if(num>=1)list.add(0);
		if(num>=2)list.add(1);
		for (int i = 3; i <= num; i++) {
			list.add(list.get(i-2)+list.get(i-3));
		}
		return list;
	}

	public static int Fibonacci(int n) {
		if (n == 1)
			return 0;
		if (n <= 3)
			return 1;
		else
			return Fibonacci(n - 1) + Fibonacci(n - 2);
	}
}

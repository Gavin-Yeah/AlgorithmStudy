package ChallengeSet.Drawbridge;

import java.util.Stack;

public class ValidParenthesis {
	public static void main(String[] args) {
		String a="<><<>";
		int c= Integer.parseInt("43");
		int b=12;
		String d=Integer.toString(b);
		System.out.println(c+d);
		System.out.println(isValid(a, 1));
	}
public static boolean isValid(String str, int count) {
	Stack<Character> stack= new Stack<>();
	for(int i=0;i<str.length();i++) {
		if(str.charAt(i)=='<') {
			stack.push(str.charAt(i));
		}else if(str.charAt(i)=='>'){
			if(stack.isEmpty()) {
				if(count>0) {
					count--;
				}
				else {
					return false;
				}
			}else {
				stack.pop();
			}
		}
	}
	if(stack.isEmpty()) {
		return true;
	}
	return false;
	
}
}

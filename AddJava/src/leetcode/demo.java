package leetcode;

import java.util.Stack;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.print(isValid("("));
			
	}
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(char c:s.toCharArray()) {
			if(c=='(')  stack.push(')');
			else if(c=='[') stack.push(']');
			else if(c=='{') stack.push('}');
			else if(stack.isEmpty()||c!=stack.pop()) return false;
			
		}
		return stack.isEmpty();
		
	}

}

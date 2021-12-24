package arrays;

import java.util.Stack;

public class SolveStringExpression {

	public static void main(String... s) {
		String exp = "(2*3+4/2)"; // 23*42/+

		String ss = infixToPostFix(exp);

		ss = ss.replaceAll(" ", "");

		System.out.println(ss);
		System.out.println(val("23*42/+"));

	}

	public static int val(String postFix) {
		char[] aa = postFix.toCharArray();

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < aa.length; i++) {
			char c=postFix.charAt(i);
			if(Character.isDigit(c)) 
	            stack.push(c - '0');
			else {

				int val1 = stack.pop();
				int val2 = stack.pop();

				switch (c) {
				case '+':
					 stack.push(val2 + val1);
					 break;
				case '-':
					 stack.push(val2 - val1);
					 break;
				case '*':
					 stack.push(val2 * val1);
					 break;

				case '/':
					 stack.push(val2 / val1);
					 break;
				}

			}
		}
		return stack.pop();
	}

	public static String infixToPostFix(String s) {

		char[] a = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		String result = "";
		for (int i = 0; i < a.length; i++) {

			if (Character.isLetterOrDigit(a[i]))
				result += a[i] + " ";

			else if (a[i] == '(') {
				stack.push(a[i]);
			} else if (a[i] == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop() + " ";
				}
				stack.pop();
			} else {
				if (!stack.isEmpty() && precedence(a[i]) > precedence(stack.peek())) {
					stack.push(a[i]);
				} else {
					while (!stack.isEmpty() && stack.peek() != '(') {
						result += stack.pop() + " ";
					}
					stack.push(a[i]);
				}
			}

		}

		while (!stack.isEmpty()) {
			result += stack.pop() + " ";
		}

		return result;
	}

	static int precedence(Character c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}

		return -1;
	}
}

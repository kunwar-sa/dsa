package P031ValidParentheses;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		System.out.println(isValidParenthesis("{}{}{}{}{{{{)))){{{{}}}}}}}}"));
	}

	public static boolean isValidParenthesis(String expression) {
		// Write your code here.
		Stack<Character> st = new Stack<>();

		int len = expression.length();
		char ch = ' ';
		for (int i = 0; i < len; i++) {
			ch = expression.charAt(i);
			if (ch == '{' || ch == '(' || ch == '[')
				st.push(ch);
			else {
				if (st.empty()) {
					st.push(ch);
					continue;
				}
				if ((ch == '}' && st.peek() == '{') || (ch == ')' && st.peek() == '(')
						|| (ch == ']' && st.peek() == '['))
					st.pop();
				else {
					st.push(ch);
				}
			}
		}

		return st.empty();
	}
}
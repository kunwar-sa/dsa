package P033SortStack;

import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {

		Stack<Integer> s = new Stack<>();
		s.push(20);
		s.push(-1);
		s.push(12);
		s.push(3);

		sortStack(s);

		for (int x : s)
			System.out.println(x);
	}

	public static void sortStack(Stack<Integer> s) {
		// Write your code here.
		if (s.empty())
			return;

		int popped = s.pop();
		sortStack(s);
		sortedInsert(s, popped);

	}

	public static void sortedInsert(Stack<Integer> s, int x) {
		if (s.empty() || s.peek() < x) {
			s.push(x);
			return;
		}
		int popped = s.pop();
		sortedInsert(s, x);
		s.push(popped);
	}
}

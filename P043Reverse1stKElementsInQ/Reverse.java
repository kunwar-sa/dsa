package P043Reverse1stKElementsInQ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse {

	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);

		q = modifyQueue(q, 3);

		for (Integer x : q) {
			System.out.println(x);
		}
	}

	public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
		// add code here.
		Stack<Integer> st = new Stack<>();

		// 1 2 3 4 5
		for (int i = 0; i < k; i++) {
			st.push(q.remove());
		}

		while (!st.isEmpty()) {
			q.add(st.pop());
		}

		int n = q.size();
		int x = 0;
		for (int i = 0; i < n - k; i++) {
			x = q.remove();
			q.add(x);
		}

		return q;
	}
}

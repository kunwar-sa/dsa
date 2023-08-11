package P044InterleafQ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleafQ {

	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		q.add(7);
		q.add(8);
		interleaf(q);

		for (Integer x : q)
			System.out.println(x);
	}

	public static Queue<Integer> interleaf(Queue<Integer> q) {

		Stack<Integer> st = new Stack<>();

		int n = q.size();

		for (int i = 0; i < n / 2; i++)
			st.push(q.remove());

		while (!st.isEmpty())
			q.add(st.pop());

		for (int i = 0; i < n / 2; i++)
			q.add(q.remove());

		for (int i = 0; i < n / 2; i++)
			st.push(q.remove());

		while (!st.isEmpty()) {
			q.add(st.pop());
			q.add(q.remove());
		}

		return q;
	}
}

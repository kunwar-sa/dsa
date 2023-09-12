package P047TopView;

import java.util.*;

public class TopView {

	static ArrayList<Integer> topView(Node root) {

		// add your code
		ArrayList<Integer> ans = new ArrayList<>();

		if (root == null)
			return ans;

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(0, root));

		while (!q.isEmpty()) {

			Pair p = q.poll();
			int hd = p.hd;
			Node curr = p.node;

			if (!map.containsKey(hd)) {
				map.put(hd, curr.data);
			}

			if (curr.left != null)
				q.add(new Pair(hd - 1, curr.left));
			if (curr.right != null)
				q.add(new Pair(hd + 1, curr.right));
		}

		for (Integer x : map.values()) {
			ans.add(x);
		}

		return ans;

	}

	static class Pair {
		int hd;
		Node node;

		Pair(int hd, Node node) {
			this.hd = hd;
			this.node = node;
		}
	}

}

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

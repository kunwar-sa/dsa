package P049LeftView;

import java.util.*;

public class LeftView {

	ArrayList<Integer> leftView(Node root) {
		// Your code here
		ArrayList<Integer> ans = new ArrayList<>();

		if (root == null)
			return ans;

		Map<Integer, List<Integer>> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(0, root));

		while (!q.isEmpty()) {
			Pair p = q.poll();
			int vd = p.vd;
			Node curr = p.node;

			if (map.containsKey(vd)) {
				map.get(vd).add(curr.data);
			} else {
				List<Integer> li = new ArrayList<>();
				li.add(curr.data);
				map.put(vd, li);
			}

			if (curr.left != null)
				q.add(new Pair(vd + 1, curr.left));
			if (curr.right != null)
				q.add(new Pair(vd + 1, curr.right));

		}

		for (List<Integer> x : map.values()) {
			ans.add(x.get(0));

		}

		return ans;
	}

	class Pair {
		int vd;
		Node node;

		Pair(int vd, Node node) {
			this.vd = vd;
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
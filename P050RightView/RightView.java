package P050RightView;

import java.util.*;

public class RightView {

	ArrayList<Integer> rightView(Node root) {
		// add code here.
		ArrayList<Integer> ans = new ArrayList<>();

		if (root == null)
			return ans;

		Map<Integer, Integer> map = new TreeMap<>();

		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(0, root));

		while (!q.isEmpty()) {
			Pair p = q.poll();
			int vd = p.vd;
			Node node = p.node;

			map.put(vd, node.data);

			if (root.left != null)
				q.add(new Pair(vd + 1, root.left));
			if (root.right != null)
				q.add(new Pair(vd + 1, root.right));
		}

		for (int x : map.values())
			ans.add(x);

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

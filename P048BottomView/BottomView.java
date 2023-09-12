package P048BottomView;

import java.util.*;

public class BottomView {

	public ArrayList<Integer> bottomView(Node root) {
		// Code here
		ArrayList<Integer> ans = new ArrayList<>();

		if (root == null)
			return ans;

		Map<Integer, List<Integer>> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(0, root));

		while (!q.isEmpty()) {

			Pair p = q.poll();
			int hd = p.hd;
			Node curr = p.node;

			if (map.containsKey(hd))
				map.get(hd).add(curr.data);
			else {
				List<Integer> li = new ArrayList<>();
				li.add(curr.data);
				map.put(hd, li);
			}

			if (curr.left != null)
				q.add(new Pair(hd - 1, curr.left));
			if (curr.right != null)
				q.add(new Pair(hd + 1, curr.right));
		}

		for (Map.Entry<Integer, List<Integer>> x : map.entrySet())
			ans.add(x.getValue().get(x.getValue().size() - 1));

		return ans;
	}

	class Pair {
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

package P046VerticalTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

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

public class VerticalTraversal {

	static class Pair {
		int hd;
		Node node;

		Pair(int hd, Node node) {
			this.hd = hd;
			this.node = node;
		}
	}

	static ArrayList<Integer> verticalOrder(Node root) {

		ArrayList<Integer> ans = new ArrayList<>();

		if (root == null)
			return ans;

		Map<Integer, List<Integer>> map = new TreeMap<>();

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, root));

		while (!q.isEmpty()) {

			Pair pair = q.poll();
			int hd = pair.hd;
			Node curr = pair.node;

			if (map.containsKey(hd)) {
				map.get(hd).add(curr.data);
			} else {
				List<Integer> li = new ArrayList<>();
				li.add(curr.data);
				map.put(hd, li);
			}

			if (curr.left != null) {
				q.add(new Pair(hd - 1, curr.left));
			}
			if (curr.right != null) {
				q.add(new Pair(hd + 1, curr.right));
			}

		}

		for (Map.Entry<Integer, List<Integer>> x : map.entrySet()) {
			for (Integer y : x.getValue()) {
				ans.add(y);
			}
		}

		return ans;
	}
}

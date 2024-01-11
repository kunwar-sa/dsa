package P054BurnTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BurnTree {

	static Map<Node, Node> parent = new HashMap<>();

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

	public static int minTime(Node root, int target) {
		// Your code goes here
		Node targetNode = levelOrderTraversal(root, target);
		int ans = burnTree(targetNode, parent);
		return ans;
	}

	public static Node levelOrderTraversal(Node root, int target) {

		if (root == null) {
			return root;
		}

		Node res = null;
		Queue<Node> q = new LinkedList<>();

		q.add(root);

		while (!q.isEmpty()) {

			Node curr = q.remove();

			if (curr.data == target) {
				res = curr;
			}

			if (curr.left != null) {
				parent.put(curr.left, curr);
				q.add(curr.left);
			}

			if (curr.right != null) {
				parent.put(curr.right, curr);
				q.add(curr.right);
			}

		}

		return res;
	}

	public static int burnTree(Node target, Map<Node, Node> parent) {
		Map<Node, Boolean> visited = new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		int time = 0;

		q.add(target);
		visited.put(target, true);

		while (!q.isEmpty()) {
			Boolean flag = false;
			int n = q.size();
			for (int i = 0; i < n; i++) {
				Node curr = q.remove();

				if (curr.left != null && !visited.get(curr.left)) {
					flag = true;
					q.add(curr.left);
					visited.put(curr.left, true);
				}

				if (curr.right != null && !visited.get(curr.right)) {
					flag = true;
					q.add(curr.right);
					visited.put(curr.right, true);
				}

				if (parent.get(curr) != null && !visited.get(parent.get(curr))) {
					flag = true;
					q.add(parent.get(curr));
					visited.put(parent.get(curr), true);
				}
			}
			if (flag)
				time++;

		}

		return time;
	}
}

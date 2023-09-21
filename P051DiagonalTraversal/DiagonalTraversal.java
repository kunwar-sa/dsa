package P051DiagonalTraversal;

import java.util.*;

public class DiagonalTraversal {

	public ArrayList<Integer> diagonal(Node root) {

		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();

		if (root == null)
			return ans;

		q.add(root);

		while (!q.isEmpty()) {
			Node curr = q.poll();

			while (curr != null) {
				ans.add(curr.data);

				if (curr.left != null)
					q.add(curr.left);

				curr = curr.right;
			}
		}

		return ans;

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
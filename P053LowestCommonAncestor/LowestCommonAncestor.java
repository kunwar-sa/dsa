package P053LowestCommonAncestor;

import java.util.*;

public class LowestCommonAncestor {

	// Function to return the lowest common ancestor in a Binary Tree.
	Node lca(Node root, int n1, int n2) {
		// Your code here
		if (root == null)
			return null;

		if (root.data == n1 || root.data == n2)
			return root;

		Node left = lca(root.left, n1, n2);
		Node right = lca(root.right, n1, n2);

		if (left != null && right != null)
			return root;
		if (left != null && right == null)
			return left;
		if (left == null && right != null)
			return right;
		else
			return null;
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
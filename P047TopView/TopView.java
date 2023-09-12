package P047TopView;

import java.util.*;

public class TopView {

	static void leftBoundary(Node root, ArrayList<Integer> ans) {

		if (root == null)
			return;

		if (root.left != null)
			leftBoundary(root.left, ans);
		else
			leftBoundary(root.right, ans);

		ans.add(root.data);

	}

	static void rightBoundary(Node root, ArrayList<Integer> ans) {

		if (root == null)
			return;

		ans.add(root.data);

		if (root.right != null)
			rightBoundary(root.right, ans);
		else
			rightBoundary(root.left, ans);

	}

	static ArrayList<Integer> topView(Node root) {

		// add your code
		ArrayList<Integer> ans = new ArrayList<>();

		if (root == null)
			return ans;

		leftBoundary(root.left, ans);
		ans.add(root.data);
		rightBoundary(root.right, ans);

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

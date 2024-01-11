package P055BSTPredecessor;

import java.util.*;

public class Iterative {

	public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
		List<Integer> ans = new ArrayList<>();

		TreeNode temp = root;
		int pred = -1;
		int succ = -1;

		while (key != temp.data) {

			if (key < temp.data) {
				succ = temp.data;
				temp = temp.left;
			} else {
				pred = temp.data;
				temp = temp.right;
			}
		}

		TreeNode leftSubtree = temp.left;
		TreeNode rightSubtree = temp.right;

		while (leftSubtree != null) {
			pred = leftSubtree.data;
			leftSubtree = leftSubtree.right;
		}

		while (rightSubtree != null) {
			succ = rightSubtree.data;
			rightSubtree = rightSubtree.left;
		}

		ans.add(pred);
		ans.add(succ);

		return ans;
	}

	/*********************************************************
	 * 
	 * Following is the TreeNode structure:
	 * 
	 ********************************************************/

	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode() {
			this.data = 0;
			this.left = null;
			this.right = null;
		}

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		TreeNode(int data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

}

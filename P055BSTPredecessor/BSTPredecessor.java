package P055BSTPredecessor;

import java.util.*;

public class BSTPredecessor {

	/*
	 * Perfectly fine logic, CodingNinjas is being stupid. Giving indexoutofbounds.
	 */

	static List<Integer> li = new ArrayList<>();

	public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
		// Write your code here.

		List<Integer> ans = new ArrayList<>();
		int n = li.size();

		for (int i = 0; i < n; i++) {

			if (li.get(i) == key) {
				if (i != 0)
					ans.add(li.get(i - 1));
				else
					ans.add(-1);
				if (i != n - 1)
					ans.add(li.get(i + 1));
				else
					ans.add(-1);
			}
		}

		return ans;
	}

	public static void lineage(TreeNode root) {
		if (root == null) {
			return;
		}

		lineage(root.left);
		li.add(root.data);
		lineage(root.right);
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

package P052LongestBloodlineSum;

import java.util.*;

public class BloodlineSum {

	int totalSum = -1;
	int totalLength = 0;

	public int sumOfLongRootToLeafPath(Node root) {
		// code here

		solve(root, 0, 0);

		return totalSum;
	}

	public void solve(Node root, int sum, int length) {

		if (root == null) {

			if (length > totalLength) {
				totalLength = length;
				totalSum = sum;
			} else if (length == totalLength) {
				totalSum = Math.max(totalSum, sum);
			}

			return;
		}

		sum += root.data;

		solve(root.left, sum, length + 1);
		solve(root.right, sum, length + 1);

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
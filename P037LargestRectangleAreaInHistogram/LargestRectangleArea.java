package P037LargestRectangleAreaInHistogram;

import java.util.Stack;

public class LargestRectangleArea {

	public static void main(String[] args) {

		int[] heights = { 1, 1 };
		int ans = largestRectangleArea(heights);
		System.out.println(ans);
		// nextSmallerIndex(heights);
		// prevSmallerIndex(heights);
	}

	public static int largestRectangleArea(int[] heights) {

		int size = heights.length;

		int[] prev = prevSmallerIndex(heights);
		int[] next = nextSmallerIndex(heights);

		int n = 0;
		int p = 0;
		int width = 0;
		int area = -1;

		for (int i = 0; i < size; i++) {
			p = prev[i];
			if (next[i] == -1)
				next[i] = size;
			n = next[i];
			width = n - p - 1;
			area = Math.max(area, width * heights[i]);
		}

		return area;

	}

	public static int[] nextSmallerIndex(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];

		Stack<Integer> st = new Stack<>();
		st.push(-1);

		for (int i = n - 1; i > -1; i--) {
			while (st.peek() != -1 && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			ans[i] = st.peek();
			st.push(i);
		}

		// for (int x : ans)
		// System.out.println(x);

		return ans;
	}

	public static int[] prevSmallerIndex(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];

		Stack<Integer> st = new Stack<>();
		st.push(-1);

		for (int i = 0; i < n; i++) {
			while (st.peek() != -1 && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			ans[i] = st.peek();
			st.push(i);
		}

		// for (int x : ans)
		// System.out.println(x);

		return ans;
	}
}

package P038CelebrityProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CelebrityProblem {

	public static void main(String[] args) {

		int[][] arr = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
		int ans = celebrity2(arr, arr.length);

		System.out.println(ans);
	}

	public static int celebrity(int M[][], int n) {

		int ans = -1;
		List<Integer> halfCel = new ArrayList<>();

		for (int i = 0; i < n; i++) {

			boolean knowsNoOne = true;

			for (int j = 0; j < n; j++) {
				if (M[i][j] == 1) {
					knowsNoOne = false;
					break;
				}
			}

			if (knowsNoOne)
				halfCel.add(i);
		}

		for (int j : halfCel) {

			boolean knownByEveryone = true;

			for (int i = 0; i < n; i++) {

				if (i != j && M[i][j] == 0) {
					knownByEveryone = false;
					break;
				}
			}

			if (knownByEveryone) {
				ans = j;
				break;
			}

		}

		return ans;
	}

	// using stacks
	public static int celebrity2(int M[][], int n) {

		int ans = -1;
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			st.push(i);
		}

		while (st.size() > 1) {

			int person1 = st.pop();
			int person2 = st.pop();

			if (M[person1][person2] == 1) {
				st.push(person2);
			}

			else {
				st.push(person1);
			}
		}

		int halfCel = st.pop();

		for (int j = 0; j < n; j++) {
			if (M[halfCel][j] != 0)
				return ans;
		}

		for (int i = 0; i < n; i++) {
			if (i != halfCel && M[i][halfCel] != 1)
				return ans;
		}

		ans = halfCel;
		return ans;
	}
}

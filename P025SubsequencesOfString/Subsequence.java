package P025SubsequencesOfString;

import java.util.ArrayList;

public class Subsequence {

	public static void main(String[] args) {

		ArrayList<String> ans = subsequences("abc");
		System.out.println(ans.size());
		for (String x : ans)
			System.out.println(x);
	}

	public static ArrayList<String> subsequences(String str) {
		// Write your code here

		ArrayList<String> ans = new ArrayList<>();
		String subseq = "";
		int index = 0;
		findSubsequences(str, index, subseq, ans);

		return ans;

	}

	public static void findSubsequences(String str, int index, String subseq, ArrayList<String> ans) {

		if (index == str.length()) {
			if (subseq.length() > 0)
				ans.add(subseq);
			return;
		}

		findSubsequences(str, index + 1, subseq, ans);

		// new subsequence
		subseq += str.charAt(index);
		findSubsequences(str, index + 1, subseq, ans);
	}
}

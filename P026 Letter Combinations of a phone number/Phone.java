import java.util.ArrayList;
import java.util.List;

public class Phone {

    public static void main(String[] args) {

        List<String> ans = letterCombinations("");
        for (String x : ans)
            System.out.println(x);
    }

    public static List<String> letterCombinations(String digits) {

        String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        int index = 0;
        String comb = "";
        List<String> ans = new ArrayList<>();

        solve(digits, index, comb, ans, mapping);

        return ans;
    }

    public static void solve(String digits, int index, String comb, List<String> ans, String[] mapping) {

        if (index >= digits.length()) {
            if (comb.length() > 0)
                ans.add(comb);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            String s = comb + letters.charAt(i);
            solve(digits, index + 1, s, ans, mapping);
        }

    }
}

/*
 * Medium level leetcode question.
 * Only saw dry-run.
 * Came up with a recursive solution
 * ON MY OWN.
 * All test cases passed.
 * This was also a backtracking question.
 */

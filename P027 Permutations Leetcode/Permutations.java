import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4 };
        List<List<Integer>> ans = permute(arr);
        for (List<Integer> x : ans) {
            for (Integer y : x)
                System.out.print(y);
            System.out.println();
        }

    }

    public static List<List<Integer>> permute(int[] nums) {

        List<Integer> n = new ArrayList<>();
        for (int x : nums)
            n.add(x);
        int index = 0;
        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        solve(n, index, sub, ans, nums.length);
        return ans;

    }

    public static void solve(List<Integer> nums, int index, List<Integer> sub, List<List<Integer>> ans, int len) {
        if (index >= len) {
            ans.add(sub);
            return;
        }

        for (Integer n : nums) {

            List<Integer> subarr = new ArrayList<>(sub);
            subarr.add(n);

            List<Integer> li = new ArrayList<>(nums);
            li.remove(n);
            solve(li, index + 1, subarr, ans, len);
        }

    }
}

/*
 * Medium level leetcode question.
 * Solved myself.
 * Didn't even see the dry-run.
 * Took no help at all.
 * All by myself.
 * Hell yeah.
 */

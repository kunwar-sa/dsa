import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    public static void main(String[] args) {

        String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" };
        String[] words2 = { "l", "e" };

        List<String> univ = wordSubsets(words1, words2);
        for (String x : univ) {
            System.out.println(x);
        }
    }

    public static int[] count(String s) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++)
            count[s.charAt(i) - 'a']++;
        return count;
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {

        int[] count = count(words2[0]);
        int len = words2.length;
        for (int i = 1; i < len; i++) {

            int[] count2 = count(words2[i]);

            for (int j = 0; j < 26; j++) {
                if (count2[j] > count[j])
                    count[j] = count2[j];
            }
        }

        List<String> ans = new ArrayList<>();
        for (String x : words1) {
            boolean universal = true;
            int[] countWords1 = count(x);

            for (int j = 0; j < 26; j++) {
                if (count[j] != 0 && countWords1[j] < count[j]) {
                    universal = false;
                    break;
                }

            }

            if (universal)
                ans.add(x);
        }
        return ans;
    }
}

/*
 * medium level question.
 * created solution myself.
 * 10% cases failed due to TLE.
 * Needed only a hint to create a working solution.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumScore {

    public static void main(String[] args) {

        String[] words = { "da", "ac", "aba", "abcc", "cadc" };
        char[] letters = { 'a', 'a', 'a', 'a', 'b', 'c', 'c', 'c', 'd', 'd', 'd' };
        int[] score = { 3, 7, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        System.out.println(maxScoreWords(words, letters, score));
    }

    public static boolean canFit(String s, int[] score, int[] totalScoreCopy) {

        boolean ans = true;
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (totalScoreCopy[ch - 'a'] > 0) {
                totalScoreCopy[ch - 'a'] -= score[ch - 'a'];
            } else {
                ans = false;
                break;
            }

        }
        return ans;
    }

    public static void revive(int[] totalScoreCopy, int[] totalScore) {

        for (int k = 0; k < totalScore.length; k++)
            totalScoreCopy[k] = totalScore[k];
    }

    public static List<List<String>> subsets(List<String> nums) {

        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (String n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<String> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int ans = 0;
        int[] totalScore = new int[26];

        for (char ch : letters) {
            totalScore[ch - 'a'] += score[ch - 'a'];
        }

        Map<String, Integer> map = new HashMap<>();
        List<String> validWords = new ArrayList<>();

        for (String s : words) {

            int[] totalScoreCopy = new int[totalScore.length];
            for (int i = 0; i < totalScore.length; i++)
                totalScoreCopy[i] = totalScore[i];

            int finalScore = 0;
            boolean wordValidHai = true;

            for (int i = 0; i < s.length(); i++) {

                char ch = s.charAt(i);
                if (score[ch - 'a'] == 0) {
                    wordValidHai = false;
                    break;
                }
                if (totalScoreCopy[ch - 'a'] > 0) {
                    finalScore += score[ch - 'a'];
                    totalScoreCopy[ch - 'a'] -= score[ch - 'a'];
                }

            }
            if (wordValidHai) {
                // System.out.println(s);
                validWords.add(s);
                map.put(s, finalScore);
                System.out.println(s + " " + finalScore);
            }

        }

        int n = validWords.size();

        List<List<String>> li = subsets(validWords);

        for (List<String> x : li) {

            int[] totalScoreCopy = new int[totalScore.length];
            revive(totalScoreCopy, totalScore);

            int total = 0;
            for (String y : x) {
                if (canFit(y, score, totalScoreCopy))
                    total += map.get(y);
            }
            if (total > ans)
                ans = total;
        }

        return ans;
    }
}

/*
 * First Hard Level qs. attempt.
 * took me whole day.
 * had the right approach.
 * needed one very obvious hint.
 * needed help for using brute force.
 * brute force waali kya cheez hai ye khud pata kiya
 * this was a brute force question
 * had to find all subsets in an array for which I did not have the energy so
 * directly copy pasted code from leetcode.
 * LEARN BACKTRACKING please.
 */

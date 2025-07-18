package P058MaximalRectangle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class MaximalRectangle {

    record Pair(int index, int height) {
    };

    public int maximalRectangle(char[][] matrix) {

        int max = 0;

        List<List<Integer>> histogram = histogram(matrix);

        for (List<Integer> hist : histogram) {

            Deque<Pair> stack = new ArrayDeque<>();

            for (int i = 0; i < hist.size(); i++) {

                int start = i;
                while (!stack.isEmpty() && stack.getLast().height > hist.get(i)) {
                    Pair p = stack.removeLast();
                    max = Math.max(max, p.height * (i - p.index));
                    start = p.index;
                }
                stack.addLast(new Pair(start, hist.get(i)));
            }

            for (Pair p : stack) {
                max = Math.max(max, p.height * (hist.size() - p.index));
            }
        }

        return max;
    }

    // convert every row of the char array into a histogram
    public static List<List<Integer>> histogram(char[][] arr) {

        int n = arr.length;
        int m = arr[0].length;

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> prev = new ArrayList<>(Collections.nCopies(m, 0));

        for (int i = 0; i < n; i++) {

            List<Integer> hist = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '1')
                    hist.add(1 + prev.get(j));
                else
                    hist.add(0);
            }
            prev = hist;
            ans.add(hist);
        }

        return ans;
    }
}

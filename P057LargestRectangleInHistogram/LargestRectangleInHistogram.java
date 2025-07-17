package P057LargestRectangleInHistogram;

import java.util.*;

public class LargestRectangleInHistogram {

    public record Pair(int index, int height) {
    }

    public int largestRectangleArea(int[] heights) {

        int max = 0;
        Deque<Pair> stack = new ArrayDeque<>();
        int start;

        for (int i = 0; i < heights.length; i++) {

            start = i;

            while (!stack.isEmpty() && heights[i] < stack.getLast().height) {
                Pair p = stack.removeLast();
                max = Math.max(max, p.height * (i - p.index));
                start = p.index;
            }
            stack.add(new Pair(start, heights[i]));
        }

        for (Pair p : stack)
            max = Math.max(max, p.height * (heights.length - p.index));

        return max;
    }
}

package P063MergeIntervals;

import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        // sort the interval array by the starting time of each interval
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // store the first interval
        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        // start iterating from the 2nd interval
        for (int i = 1; i < intervals.length; i++) {

            int[] curr = intervals[i];
            // in there is an overlap, then increase the previous intervals end time to
            // current intervals end time
            if (prev[1] >= curr[0]) {
                prev[1] = Math.max(prev[1], curr[1]);
            }
            // if there is no overlap then just add the previous interval to the answer
            // and make the current interval as the previous interval
            else {
                merged.add(prev);
                prev = curr;
            }
        }

        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }
}

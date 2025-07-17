package P056MaximalSquare;

import java.util.HashMap;
import java.util.Map;

public class MaximalSquare {

    public record pair(int x, int y) {
    };

    public int maximalSquare(char[][] matrix) {

        Map<Record, Integer> map = new HashMap<>();
        solve(matrix, map, 0, 0);
        return (int) Math.pow((map.values().stream().max(Integer::compareTo).get()), 2);
    }

    public int solve(char[][] mat, Map<Record, Integer> map, int r, int c) {

        if (r >= mat.length || c >= mat[0].length) {
            return 0;
        }

        if (!map.containsKey(new pair(r, c))) {
            int down = solve(mat, map, r + 1, c);
            int right = solve(mat, map, r, c + 1);
            int diag = solve(mat, map, r + 1, c + 1);

            map.put(new pair(r, c), 0);

            if (mat[r][c] == '1') {
                map.put(new pair(r, c), 1 + Math.min(down, Math.min(right, diag)));
            }

        }

        return map.get(new pair(r, c));

    }

}

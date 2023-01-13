import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {

    }

    /*
     * Medium level qs.
     * only saw the approach to come up with my own solution.
     * had already made more than 80% of correct solution.
     */

    public static List<Integer> spiralOrder(int[][] matrix) {
        int topBorder = 0;
        int bottomBorder = matrix.length - 1;
        int leftBorder = 0;
        int rightBorder = matrix[0].length - 1;
        int iterations = 0;
        int total = matrix.length * matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int i = topBorder;
        int j = leftBorder;
        while (iterations < total) {
            for (j = leftBorder; iterations < total && j <= rightBorder; j++) {
                ans.add(matrix[i][j]);
                iterations++;
            }
            topBorder++;
            j--;
            for (i = topBorder; iterations < total && i <= bottomBorder; i++) {
                ans.add(matrix[i][j]);
                iterations++;
            }
            rightBorder--;
            i--;
            for (j = rightBorder; iterations < total && j >= leftBorder; j--) {
                ans.add(matrix[i][j]);
                iterations++;
            }
            bottomBorder--;
            j++;
            for (i = bottomBorder; iterations < total && i >= topBorder; i--) {
                ans.add(matrix[i][j]);
                iterations++;
            }
            leftBorder++;
            i++;
        }
        return ans;
    }

}

public class RotateImage {

    public static void main(String[] args) {

    }

    /*
     * Medium level qs.
     * Solved myself.
     * In one hour.
     */

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = matrix.length;
        int[][] arr = new int[n][m];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[j][count - i - 1] = arr[i][j];
            }
        }
    }

}

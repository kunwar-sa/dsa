public class SearchInMatrixII {

    public static void main(String[] args) {

    }

    /* only needed help in approach */

    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean ans = false;
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int y = row;
        int x = 0;
        while (x <= col && y >= 0) {
            int current = matrix[y][x];
            if (target == current) {
                ans = true;
                break;
            }
            if (target > current)
                x++;
            else
                y--;
        }
        return ans;
    }

}

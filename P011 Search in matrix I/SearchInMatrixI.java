public class SearchInMatrixI {
    public static void main(String[] args) {

    }

    /*
     * time laga(2-3 ghante hi :D), lekin khud kiya
     * medium level ka tha ye qs.
     */

    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean ans = false;
        boolean foundInY = false;
        int start = 0;
        int end = matrix.length - 1;
        int width = matrix[0].length - 1;
        int y = 0;
        int mid = (start + (end - start)) / 2;
        while (start <= end) {
            if (target >= matrix[mid][0] && target <= matrix[mid][width]) {
                foundInY = true;
                y = mid;
                break;
            }
            if (target < matrix[mid][0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        start = 0;
        end = width;
        mid = start + (end - start) / 2;
        while (foundInY && start <= end) {
            if (target == matrix[y][mid]) {
                ans = true;
                break;
            }
            if (target < matrix[y][mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return ans;
    }

}

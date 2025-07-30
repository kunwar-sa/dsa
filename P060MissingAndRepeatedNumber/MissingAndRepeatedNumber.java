package P060MissingAndRepeatedNumber;

public class MissingAndRepeatedNumber {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];

        int l = grid.length;
        int n = l * l;

        long sum_n = (long) n * (n + 1) / 2;
        long sum_sq_n = (long) n * (n + 1) * (2 * n + 1) / 6;

        long giv_sum_n = 0;
        long giv_sum_sq_n = 0;
        for (int i = 0; i < l; i++)
            for (int j = 0; j < l; j++) {
                giv_sum_n += grid[i][j];
                giv_sum_sq_n += grid[i][j] * grid[i][j];
            }

        long diff = giv_sum_n - sum_n;
        long diff_sq = giv_sum_sq_n - sum_sq_n;

        long sum_a_b = diff_sq / diff;

        ans[0] = (int) ((sum_a_b + diff) / 2);
        ans[1] = (int) ((sum_a_b - diff) / 2);

        return ans;
    }

    public static int[] findMissingAndRepeatedValues2(int[] arr) {
        int[] ans = new int[2];

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            int val = arr[i];

            if (arr[val - 1] > 0)
                arr[val - 1] = -arr[val - 1];
            else
                ans[0] = val;
        }

        for (int i = 0; i < n; i++)
            if (arr[i] > 0) {
                ans[1] = i + 1;
                break;
            }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 2, 4 };
        int[] ans = findMissingAndRepeatedValues2(arr);
        System.out.println(ans[0] + " " + ans[1]);
    }
}

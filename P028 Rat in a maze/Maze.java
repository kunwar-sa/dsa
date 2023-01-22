import java.util.ArrayList;

public class Maze {

    public static void main(String[] args) {

        int[][] m = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

        ArrayList<String> ans = findPath(m, 4);

        System.out.println(ans.size());
        for (String x : ans)
            System.out.println(x);
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0)
            return ans;

        // creating visit matrix
        int[][] v = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                v[i][j] = 0;

        v[0][0] = 1;

        rec(m, v, 0, 0, n, "", ans);
        return ans;
    }

    public static void rec(int[][] m, int[][] v, int i, int j, int n, String path, ArrayList<String> ans) {

        // base case

        // aa gaye
        if (i == n - 1 && j == n - 1) {
            ans.add(path);
            // v[i][j] = 0;
            return;
        }

        // phans gaye
        if ((i + 1 == n || m[i + 1][j] == 0 || v[i + 1][j] == 1)
                && (i - 1 == -1 || m[i - 1][j] == 0 || v[i - 1][j] == 1)
                && (j + 1 == n || m[i][j + 1] == 0 || v[i][j + 1] == 1)
                && (j - 1 == -1 || m[i][j - 1] == 0 || v[i][j - 1] == 1)) {
            // ans.add(path);
            // v[i][j] = 0;
            return;
        }

        // DOWN
        if (i + 1 < n && m[i + 1][j] == 1 && v[i + 1][j] == 0) {
            String p = path;
            p += "D";
            v[i + 1][j] = 1;
            rec(m, v, i + 1, j, n, p, ans);
            v[i + 1][j] = 0;
        }

        // UP
        if (i - 1 > -1 && m[i - 1][j] == 1 && v[i - 1][j] == 0) {
            String p = path;
            p += "U";
            v[i - 1][j] = 1;
            rec(m, v, i - 1, j, n, p, ans);
            v[i - 1][j] = 0;
        }

        // RIGHT
        if (j + 1 < n && m[i][j + 1] == 1 && v[i][j + 1] == 0) {
            String p = path;
            p += "R";
            v[i][j + 1] = 1;
            rec(m, v, i, j + 1, n, p, ans);
            v[i][j + 1] = 0;
        }

        // LEFT
        if (j - 1 > -1 && m[i][j - 1] == 1 && v[i][j - 1] == 0) {
            String p = path;
            p += "L";
            v[i][j - 1] = 1;
            rec(m, v, i, j - 1, n, p, ans);
            v[i][j - 1] = 0;
        }

    }

}

/*
 * Are you f*cking kidding me
 * Sirf approach dekha
 * aur pura solution bana dala
 * approach bhi 90% sahi socha tha
 * this question was from the holy grail of recursion questions
 */

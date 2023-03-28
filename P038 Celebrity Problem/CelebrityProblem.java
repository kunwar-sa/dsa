import java.util.ArrayList;
import java.util.List;

public class CelebrityProblem {

    public static void main(String[] args) {

        int[][] arr = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
        int ans = celebrity(arr, arr.length);

        System.out.println(ans);
    }

    public static int celebrity(int M[][], int n) {

        int ans = -1;
        List<Integer> halfCel = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            boolean knowsNoOne = true;

            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    knowsNoOne = false;
                    break;
                }
            }

            if (knowsNoOne)
                halfCel.add(i);
        }

        for (int j : halfCel) {

            boolean knownByEveryone = true;

            for (int i = 0; i < n; i++) {

                if (i != j && M[i][j] == 0) {
                    knownByEveryone = false;
                    break;
                }
            }

            if (knownByEveryone) {
                ans = j;
                break;
            }

        }

        return ans;
    }
}

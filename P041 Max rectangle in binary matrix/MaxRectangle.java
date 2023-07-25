import java.util.Stack;

public class MaxRectangle {

    public static void main(String[] args) {

    }

    public static int maxArea(int M[][], int n, int m) {
        // add code here.
        return 0;
    }

    public static int[] nextSmallerElement(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = n; i > -1; i--) {

            int curr = arr[i];

            while (st.peek() != -1 && arr[st.peek()] > curr) {
                st.pop();
            }

        }

        return null;
    }
}

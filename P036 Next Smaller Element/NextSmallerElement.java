import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerElement {

    public static void main(String[] args) {

        ArrayList<Integer> li = new ArrayList<>();
        li.add(2);
        li.add(1);
        li.add(4);
        li.add(3);

        int n = li.size();

        ArrayList<Integer> ans = nextSmallerElement(li, n);

        for (int x : ans)
            System.out.println(x);
    }

    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int e = -1;
        int peek = -1;

        for (int i = n - 1; i > -1; i--) {

            peek = st.peek();
            e = arr.get(i);

            if (peek < e) {
                ans.add(peek);
                st.push(e);
            } else {
                while (st.peek() >= e) {
                    st.pop();
                }
                ans.add(st.peek());
                st.push(e);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}

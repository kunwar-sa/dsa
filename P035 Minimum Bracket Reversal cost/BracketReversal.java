import java.util.Stack;

public class BracketReversal {

    public static void main(String[] args) {
        String str = "{{}{}}}}}{}{";
        int ans = findMinimumCost(str);
        System.out.println(ans);
    }

    public static int findMinimumCost(String str) {
        // Write your code here
        int ans = -1;
        int len = str.length();
        int openCount = 0;
        int closeCount = 0;

        Stack<Character> st = new Stack<>();

        if (len % 2 != 0)
            return ans;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);

            if (ch == '{')
                st.push(ch);
            else if (ch == '}' && !st.empty() && st.peek() == '{')
                st.pop();
            else
                st.push(ch);
        }

        for (char ch : st) {
            if (ch == '{')
                openCount++;
            else
                closeCount++;
        }

        ans = ((openCount + 1) / 2) + ((closeCount + 1) / 2);

        return ans;
    }
}

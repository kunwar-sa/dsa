import java.util.Stack;

public class RedundantBrackets {

    public static void main(String[] args) {

        String s = "(a+c*b)+(c))";
        boolean ans = findRedundantBrackets(s);
        System.out.println(ans);

    }

    // ((a/b))
    public static boolean findRedundantBrackets(String s) {
        // Write your code here.
        boolean redundant = true;
        int len = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '/' || ch == '*' || ch == '+' || ch == '-') {
                stack.push(ch);
            } else {
                if (ch == ')') {

                    redundant = true;
                    while (stack.peek() != '(') {
                        char ch2 = stack.pop();
                        if (ch2 == '/' || ch2 == '*' || ch2 == '+' || ch2 == '-') {
                            redundant = false;
                        }
                    }
                    stack.pop();
                    if (redundant)
                        return true;
                }
            }
        }

        return false;
    }
}

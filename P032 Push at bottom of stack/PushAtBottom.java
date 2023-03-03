import java.util.Stack;

public class PushAtBottom {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(7);
        s.push(1);
        s.push(4);
        s.push(5);

        s = pushAtBottom(s, 9);

        for (int x : s)
            System.out.println(x);
    }

    public static Stack<Integer> pushAtBottom(Stack<Integer> s, int x) {
        // Write your code here
        int top = s.size();
        s.push(-1);
        while (top > 0) {
            s.set(top, s.get(top--));

        }
        s.add(0, x);
        s.pop();
        return s;
    }
}

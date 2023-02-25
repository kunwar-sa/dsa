public class TwoStack {

    int[] arr;
    int top1;
    int top2;
    int size;

    // Initialize TwoStack.
    public TwoStack(int s) {

        arr = new int[2 * s];
        top1 = -1;
        top2 = s - 1;
        size = s;
    }

    // Push in stack 1.
    public void push1(int num) {

        top1++;
        if (top1 <= size - 1)
            arr[top1] = num;
        else
            top1--;
    }

    // Push in stack 2.
    public void push2(int num) {

        top2++;
        if (top2 <= size * 2 - 1)
            arr[top2] = num;
        else
            top2--;
    }

    // Pop from stack 1 and return popped element.
    public int pop1() {

        int popped = -1;

        if (top1 > -1) {
            popped = arr[top1];
            top1--;
        }
        return popped;
    }

    // Pop from stack 2 and return popped element.
    public int pop2() {

        int popped = -1;

        if (top2 > size - 1) {
            popped = arr[top2];
            top2--;
        }
        return popped;
    }

}

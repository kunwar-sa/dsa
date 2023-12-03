package P030TwoStacksUsingArray;

public class TwoStackLogic2 {

	int[] arr;
	int top1;
	int top2;
	int size;

	// Initialize TwoStack.
	public TwoStackLogic2(int s) {

		arr = new int[s];
		top1 = -1;
		top2 = s;
		size = s;
	}

	// Push in stack 1.
	public void push1(int num) {
		top1++;
		if (top1 < top2) {
			arr[top1] = num;
		} else {
			top1--;
		}
	}

	// Push in stack 2.
	public void push2(int num) {
		top2--;
		if (top2 > top1) {
			arr[top2] = num;
		} else {
			top2++;
		}
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
		if (top2 < size) {
			popped = arr[top2];
			top2++;
		}
		return popped;
	}
}

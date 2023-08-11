package P022CheckBinaryRepresentationPalindrome;

public class Palindrome {

	public static void main(String[] args) {

		System.out.println(checkPalindrome(10));
	}

	public static boolean checkPalindrome(long N) {
		// Write your code here.

		String num = Long.toBinaryString(N);
		char[] c = num.toCharArray();

		int i = 0;
		int j = c.length - 1;

		return check(i, j, c);
	}

	public static boolean check(int i, int j, char[] c) {
		if (i > j)
			return true;

		if (c[i] != c[j])
			return false;
		else
			return check(i + 1, j - 1, c);
	}

}

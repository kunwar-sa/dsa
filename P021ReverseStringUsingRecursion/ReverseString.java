package P021ReverseStringUsingRecursion;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverseString("abcde"));
	}

	public static String reverseString(String str) {
		// Write your code here.
		int i = 0;
		int j = str.length() - 1;
		char[] s = str.toCharArray();
		reverse(i, j, s);
		String ans = "";
		for (char x : s) {
			ans += x;
		}
		return ans;
	}

	public static void reverse(int i, int j, char[] str) {

		if (i > j)
			return;

		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;

		i++;
		j--;
		reverse(i, j, str);

	}
}

package P007StringCompression;

public class StringCompression {

	public static void main(String[] args) {

	}

	/*
	 * Medium level qs., did myself. Stupid description so needed little help.
	 */

	public static int compress(char[] chars) {
		if (chars.length == 1)
			return 1;
		int n = chars.length;
		int count = 1;
		int a = 0;
		// abc
		for (int i = 1; i < n; i++) {
			if (chars[i] == chars[i - 1]) {
				count++;
			} else {
				if (count == 1) {
					chars[a++] = chars[i - 1];
				} else {
					chars[a++] = chars[i - 1];
					for (char x : String.valueOf(count).toCharArray()) {
						chars[a++] = x;
					}
				}
				count = 1;
			}
		}
		chars[a++] = chars[n - 1];
		if (count != 1) {
			for (char x : String.valueOf(count).toCharArray()) {
				chars[a++] = x;
			}
		}
		for (char j : chars)
			System.out.print(j);
		return a;
	}

}

package P001ValidPalindrome;

public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("aba"));
	}

	public static boolean isPalindrome(String s) {
		char[] c = s.toCharArray();
		int start = 0;
		int end = c.length - 1;
		boolean validHai = true;
		while (start <= end) {
			// changing uppercase to lowercase
			if (c[start] >= 65 && c[start] <= 90)
				c[start] += 32;
			if (c[end] >= 65 && c[end] <= 90)
				c[end] += 32;
			// checking if the left pointer is alphanum
			if ((c[start] >= 48 && c[start] <= 57) || (c[start] >= 97 && c[start] <= 122)) {
				// checking if the right pointer is alphanum
				if ((c[end] >= 48 && c[end] <= 57) || (c[end] >= 97 && c[end] <= 122)) {
					// checking if not palindrome
					if (c[start] != c[end]) {
						validHai = false;
						break;
					}

				} else {
					end--;
					continue;
				}
			} else {
				start++;
				continue;
			}
			start++;
			end--;
		}
		return validHai;
	}

}

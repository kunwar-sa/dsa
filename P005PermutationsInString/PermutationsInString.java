package P005PermutationsInString;

public class PermutationsInString {
	public static void main(String[] args) {

		System.out.println(checkInclusion("ab", "accd"));
	}

	public static boolean checkInclusion(String s1, String s2) {
		char[] s1Chars = s1.toCharArray();
		int[] s1Freq = new int[26];
		for (char x : s1Chars) {
			s1Freq[x - 'a']++;
		}
		char[] s2Chars = s2.toCharArray();
		int[] s2Freq = new int[26];
		int i = 0;
		while (i < s1.length() && i < s2.length()) {
			s2Freq[s2Chars[i] - 'a']++;
			i++;
		}
		if (equals(s1Freq, s2Freq))
			return true;
		while (i < s2.length()) {
			s2Freq[s2Chars[i] - 'a']++;
			s2Freq[s2Chars[i - s1.length()] - 'a']--;
			if (equals(s1Freq, s2Freq))
				return true;
			i++;
		}
		return false;
	}

	public static boolean equals(int[] a, int[] b) {
		for (int i = 0; i < 26; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}

}

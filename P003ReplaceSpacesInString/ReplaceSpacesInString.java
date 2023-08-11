package P003ReplaceSpacesInString;

public class ReplaceSpacesInString {

	public static void main(String[] args) {

		System.out.println(replaceSpaces(new StringBuilder("Hi there")));
	}

	public static StringBuilder replaceSpaces(StringBuilder str) {
		// Write your code here.
		int n = str.length();
		int i = 0;
		int count = 0;
		while (i < (n + (2 * count))) {
			if (str.charAt(i) == ' ') {
				str.insert(i, "  ");
				str.replace(i, i + 3, "@40");
				count++;
			}
			i++;
		}
		return str;
	}

}

public class RemoveAllOccurencesOfSubstring {

    public static void main(String[] args) {

        System.out.println(removeOccurrences("we will rock you", "il"));
    }

    public static String removeOccurrences(String s, String part) {
        boolean flag = true;
        while (flag) {
            if (s.contains(part))
                s = s.replaceFirst(part, "");
            else
                flag = false;
        }
        return s;
    }

}

/* leetcode */

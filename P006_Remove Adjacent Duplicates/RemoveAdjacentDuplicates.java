public class RemoveAdjacentDuplicates {

    /*
     * 104/106
     * Test cases passed.TLE.O(n^2)
     */

    public static void main(String[] args) {

        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {

        char[] c = s.toCharArray();
        String str;
        boolean flag = true;
        while (flag) {
            flag = false;
            int i = 0;
            str = "";
            int n = c.length;
            while (i < n - 1) {
                if (c[i] == c[i + 1]) {
                    i += 2;
                    flag = true;
                    continue;
                } else
                    str += c[i];
                i++;
            }
            if (i < n)
                str += c[i];
            c = str.toCharArray();
        }
        return new String(c);
    }

}

public class SortSentence {

    public static void main(String[] args) {

        String s = "is2 sentence4 This1 a3";
        String sortedSentence = sortSentence(s);

        System.out.println(sortedSentence);
    }

    public static String sortSentence(String s) {

        String[] str = s.split(" ");
        insertinSort(str);
        s = "";
        for (String x : str) {

            x = x.substring(0, x.length() - 1);
            s += x + " ";

        }

        return s.substring(0, s.length() - 1);
    }

    public static void insertinSort(String[] str) {
        int n = str.length;

        for (int i = 1; i < n; i++) {
            String temp = str[i];
            int j = i - 1;
            while (j >= 0) {
                if ((temp.charAt(temp.length() - 1) - '0') < str[j].charAt(str[j].length() - 1) - '0') {
                    str[j + 1] = str[j];
                } else {
                    break;
                }
                j--;
            }

            str[j + 1] = temp;
        }

    }
}

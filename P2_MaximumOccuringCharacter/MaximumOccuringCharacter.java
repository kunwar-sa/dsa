import java.util.HashMap;
import java.util.Map;

public class MaximumOccuringCharacter {

    public static void main(String[] args) {

        System.out.println(getMaxOccuringChar("prakhar"));
    }

    public static char getMaxOccuringChar(String line) {
        // Your code here

        Map<Character, Integer> hm = new HashMap<>();
        hm.put('a', 0);
        hm.put('b', 0);
        hm.put('c', 0);
        hm.put('d', 0);
        hm.put('e', 0);
        hm.put('f', 0);
        hm.put('g', 0);
        hm.put('h', 0);
        hm.put('i', 0);
        hm.put('j', 0);
        hm.put('k', 0);
        hm.put('l', 0);
        hm.put('m', 0);
        hm.put('n', 0);
        hm.put('o', 0);
        hm.put('p', 0);
        hm.put('q', 0);
        hm.put('r', 0);
        hm.put('s', 0);
        hm.put('t', 0);
        hm.put('u', 0);
        hm.put('v', 0);
        hm.put('w', 0);
        hm.put('x', 0);
        hm.put('y', 0);
        hm.put('z', 0);

        char[] c = line.toCharArray();

        for (char x : c) {
            if (x >= 65 && x <= 90)
                x += 32;
            hm.put(x, hm.get(x) + 1);
        }

        int freq = 0;
        char mostFreq = ' ';
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > freq) {
                freq = entry.getValue();
                mostFreq = entry.getKey();
            }
        }

        return mostFreq;
    }

}

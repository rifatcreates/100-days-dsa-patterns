import java.util.*;

public class Day33_LC_0409 {
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        if (s.length() == 1) {
            return 1; 
        }

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        boolean hasOdd = false;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int freq = map.get(c);

            if (freq == 0) continue;

            if (freq % 2 == 0) {
                count += freq;
            } else if ((freq-1) % 2 == 0) {
                count += (freq-1);
                hasOdd = true;
            }

            map.put(c, 0);
        }

        if (hasOdd) count += 1;
        return count;
    }

    public static void main(String args[]) {
        String s = "abccccdd";

        System.out.println(longestPalindrome(s));
    }
}
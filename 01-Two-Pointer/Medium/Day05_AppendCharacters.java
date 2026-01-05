import java.util.*;

public class Day05_AppendCharacters {
    public static int appendCharacters(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }

            i++;
        }

        return t.length() - j;
    }

    public static void main(String args[]) {
        String s = "coaching";
        String t = "coding";

        System.out.println(appendCharacters(s, t));
    }
}
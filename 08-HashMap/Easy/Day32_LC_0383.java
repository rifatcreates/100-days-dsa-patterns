import java.util.*;

public class Day32_LC_0383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i<magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i=0; i<ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);

            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }

            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    public static void main(String args[]) {
        String ransomNote = "aa"; 
        String magazine = "aab";

        System.out.println(canConstruct(ransomNote, magazine));
    }
}
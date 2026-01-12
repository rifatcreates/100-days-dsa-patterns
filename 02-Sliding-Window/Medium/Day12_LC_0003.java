import java.util.*;

public class Day12_LC_0003 {
    public static int lengthOfLongestSubstring(String s) {
        int low = 0;
        int maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int high=0; high<s.length(); high++) {
            char chH = s.charAt(high);
            map.put(chH, map.getOrDefault(chH, 0) + 1);

            int size = high - low + 1;
            while (map.size() < size) {
                char chL = s.charAt(low);
                map.put(chL, map.get(chL) - 1);

                if (map.get(chL) == 0) {
                    map.remove(chL);
                }
                
                low++;
                size = high - low + 1;
            }

            maxLength = Math.max(maxLength, high-low+1);
        }

        return maxLength;
    }

    public static void main(String args[]) {
        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
}
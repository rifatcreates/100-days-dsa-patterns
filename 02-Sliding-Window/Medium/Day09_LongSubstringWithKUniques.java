import java.util.*;

public class Day09_LongSubstringWithKUniques {
    public static int longestSubstring(String s, int k) {
        int low = 0;
        int maxLen = -1;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int high = 0; high < s.length(); high++) {
            
            char ch = s.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while (map.size() > k) {
                char leftChar = s.charAt(low);
                map.put(leftChar, map.get(leftChar) - 1);
                
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                
                low++;
            }
            
            if (map.size() == k) {
                maxLen = Math.max(maxLen, high - low + 1);
            }
        }
        
        return maxLen;
    }

    public static void main(String args[]) {
        String s = "aabacbebebe"; 
        int k = 3;

        System.out.println(longestSubstring(s, k));
    }
}
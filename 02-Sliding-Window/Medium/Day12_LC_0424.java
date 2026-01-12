import java.util.*;

public class Day12_LC_0424 {
    public static int characterReplacement(String s, int k) {
        int low = 0;
        int maxFreq = 0;
        int maxLen = 0;

        int arr[] = new int[256];

        for (int high=0; high<s.length(); high++) {
            char chH = s.charAt(high);
            arr[chH]++;
            int size = high - low + 1;
            maxFreq = Math.max(maxFreq, arr[chH]);

            while ((size - maxFreq) > k) {
                char chL = s.charAt(low);
                arr[chL]--;
                low++;
                size = high - low + 1;
                maxFreq = Math.max(maxFreq, arr[chL]);
            }

            size = high - low + 1;
            maxLen = Math.max(maxLen, size);
        }

        return maxLen;
    }

    public static void main(String args[]) {
        String s = "ABAB"; 
        int k = 2;

        System.out.println(characterReplacement(s, k));
    }
}
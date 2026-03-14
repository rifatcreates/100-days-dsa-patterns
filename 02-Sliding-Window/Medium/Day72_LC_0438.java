import java.util.*;

public class Day72_LC_0438 {
   
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length()) {
            return res;
        }

        int pFreq[] = new int[26];
        for (int i=0; i<p.length(); i++) {
            char ch = p.charAt(i);
            pFreq[ch - 'a']++;
        }

        int low = 0;
        int high = p.length()-1;

        int windowFreq[] = new int[26];
        for (int i=low; i<=high; i++) {
            char ch = s.charAt(i);
            windowFreq[ch - 'a']++;
        }

        if (Arrays.equals(pFreq, windowFreq)) {
            res.add(low);
        }

        while (high < s.length() - 1) {
            char leftCh = s.charAt(low);
            windowFreq[leftCh - 'a']--;
            low++;

            high++;
            char rightCh = s.charAt(high);
            windowFreq[rightCh - 'a']++;

            if (Arrays.equals(pFreq, windowFreq)) {
            res.add(low);
            }
        }

        return res;
    }

    public static void main(String args[]) {
        String s = "cbaebabacd"; 
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }
}
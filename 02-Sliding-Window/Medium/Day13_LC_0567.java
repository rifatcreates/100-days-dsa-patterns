import java.util.*;

public class Day13_LC_0567 {
    public static boolean isMatch(int arr1[], int arr2[]) {
        for (int i=0; i<26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int s1Arr[] = new int[26];
        int s2Arr[] = new int[26];

        for (int i=0; i<s1.length(); i++) {
            s1Arr[s1.charAt(i) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']++;
        }

        int low = 0;
        for (int high=s1.length(); high<s2.length(); high++) {

            if (isMatch(s1Arr, s2Arr)) {
                return true;
            }

            s2Arr[s2.charAt(high) - 'a']++;
            s2Arr[s2.charAt(low) - 'a']--;

            low++;
        }

        return isMatch(s1Arr, s2Arr);
    }

    public static void main(String args[]) {
        String s1 = "ab"; 
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }
}
import java.util.*;

public class Day123_LC_0010 {
    public static boolean solve(int i, int j, String s, String p, int[][] memo) {
        if (memo[i][j] != -1) return memo[i][j] == 1;

        boolean result;
        
        if (j == p.length()) {
            return i == s.length();
        }

        boolean firstMatch = (i < s.length() && 
                             (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            result = solve(i, j + 2, s, p, memo) || 
                     (firstMatch && solve(i + 1, j, s, p, memo));
        } else {
            result = firstMatch && solve(i + 1, j + 1, s, p, memo);
        }

        memo[i][j] = result ? 1 : 0;
        return result;
    }

    public static boolean isMatch(String s, String p) {
        int[][] memo = new int[s.length() + 1][p.length() + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        
        return solve(0, 0, s, p, memo);
    }

    public static void main(String args[]) {
        String s = "aa"; 
        String p = "a";

        System.out.println(isMatch(s, p));
    }
}
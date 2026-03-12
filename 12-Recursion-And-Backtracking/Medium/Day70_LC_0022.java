import java.util.*;

public class Day70_LC_0022 {
    public static void helper(int n, int open, int close, StringBuilder temp, List<String> res) {
        if (open == n && close == n) {
            res.add(temp.toString());
            return;
        }

        if (open < n) {
            temp.append('(');
            helper(n, open+1, close, temp, res);
            temp.deleteCharAt(temp.length()-1);
        }

        if (close < open) {
            temp.append(')');
            helper(n, open, close+1, temp, res);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, 0, 0, new StringBuilder(), res);
        return res;
    }
    
    public static void main(String args[]) {
        int n = 3;

        System.out.print(generateParenthesis(n));
    }
}
import java.util.*;

public class Day69_LC_0017 {
    private static final String[] PHONE_MAP = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz" 
    };

    public static void helper(String digits, List<String> res, StringBuilder curr, int idx) {
        if (idx == digits.length()) {
            res.add(curr.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String letters = PHONE_MAP[digit - '0'];

        for (int i=0; i<letters.length(); i++) {
            curr.append(letters.charAt(i));
            helper(digits, res, curr, idx+1);
            curr.deleteCharAt(curr.length() - 1);
        } 
    }
    
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        helper(digits, res, new StringBuilder(), 0);
        return res;
    }
    
    public static void main(String args[]) {
        String digits1 = "23";
        System.out.println("Input: \"" + digits1 + "\"");
        System.out.println("Output: " + letterCombinations(digits1));
    }
}
import java.util.*;

public class Day28_LC_1047 {
    public static String removeDuplicates(String s) {
        Stack<Character> res = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);

            if (!res.isEmpty() && res.peek() == curr) {
                res.pop();
            } else {
                res.push(curr);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<res.size(); i++) {
            sb.append(res.get(i));
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String s = "abbaca";
        System.out.print(removeDuplicates(s));
    }
}
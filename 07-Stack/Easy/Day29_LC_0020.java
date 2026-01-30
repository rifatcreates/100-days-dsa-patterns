import java.util.*;

public class Day29_LC_0020 {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == '(' || curr == '{' || curr == '[') {
                st.push(curr);
                continue;
            }

            if (st.isEmpty()) {
                return false;
            }

            if (st.peek() == '(' && curr == ')') {
                st.pop();
            } else if (st.peek() == '{' && curr == '}') {
                st.pop();
            } else if (st.peek() == '[' && curr == ']') {
                st.pop();
            } else {
                return false;
            }
        }

        return st.isEmpty();
    }

    public static void main(String args[]) {
        String s = "()";

        System.out.println(isValid(s));
    }
}
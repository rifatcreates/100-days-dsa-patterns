import java.util.*;

public class Day31_LC_1209 {
    static class Pair {
        char ch;
        int num;

        Pair(char ch, int num) {
            this.ch = ch;
            this.num = num;
        }
    }

    public static String removeDuplicates(String s, int k) {
        Stack <Pair> st = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (st.isEmpty()) {
                st.push(new Pair(c, 1));
                continue;
            }

            if (st.peek().ch != c) {
                st.push(new Pair(c, 1));
                continue;
            }

            if (st.peek().num < (k-1)) {
                st.peek().num++;
            } else {
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            Pair p = st.pop();

            for (int i=0; i<p.num; i++) {
                sb.append(p.ch);
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String args[]) {
        String s = "deeedbbcccbdaa"; 
        int k = 3;

        System.out.print(removeDuplicates(s, k));
    }
}
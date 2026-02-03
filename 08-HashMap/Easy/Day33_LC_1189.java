import java.util.*;

public class Day33_LC_1189 {
    public static int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> have = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();

        for (int i=0; i<text.length(); i++) {
            char c = text.charAt(i);
            have.put(c, have.getOrDefault(c, 0) + 1);
        }

        String str = "balloon";
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int ans = Integer.MAX_VALUE;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);

            int required = need.get(c);
            if (required == 0) {
                continue;
            }
            
            int available = have.getOrDefault(c, 0);
            int possible = available / required;

            ans = Math.min(ans, possible);
            need.put(c, 0);
        }

        return ans;
    }

    public static void main(String args[]) {
        String text = "loonbalxballpoon";

        System.out.println(maxNumberOfBalloons(text));
    }
}
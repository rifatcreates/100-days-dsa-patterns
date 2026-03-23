import java.util.*;

public class Day81_LC_2272 {
    public static int largestVariance(String s) {
        int result = 0;

        for (char a = 'a'; a <= 'z'; a++) {
            for (char b = 'a'; b <= 'z'; b++) {
                if (a == b) continue;

                int sum = 0;
                boolean hasB = false;
                boolean firstB = false;

                for (char ch : s.toCharArray()) {

                    if (ch == a) {
                        sum += 1;
                    } else if (ch == b) {
                        hasB = true;

                        if (firstB && sum >= 0) {
                            firstB = false;
                        } else if (sum - 1 < 0) {
                            firstB = true;
                            sum = -1;
                        } else {
                            sum -= 1;
                        }
                    }

                    if (hasB) {
                        result = Math.max(result, sum);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        String s = "aababbb";

        System.out.println(largestVariance(s));
    }
}
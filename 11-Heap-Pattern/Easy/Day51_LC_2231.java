import java.util.*;

public class Day51_LC_2231 {
    public static int largestInteger(int num) {
         PriorityQueue<Integer> even = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Comparator.reverseOrder());

        String s = Integer.toString(num);

        for (int i=0; i<s.length(); i++) {
            int val = s.charAt(i) - '0';

            if (val % 2 == 0) {
                even.add(val);
            } else {
                odd.add(val);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            int val = s.charAt(i) - '0';

            if (val % 2 == 0) {
                sb.append(even.poll());
            } else {
                sb.append(odd.poll());
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        int num = 1234;

        System.out.println(largestInteger(num));
    }
}
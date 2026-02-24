import java.util.*;

public class Day54_LC_1405 {
    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public static String longestDiverseString(int a, int b, int c) {
         PriorityQueue<Pair> pq =
                new PriorityQueue<>((x, y) -> y.count - x.count);

        if (a > 0) pq.add(new Pair('a', a));
        if (b > 0) pq.add(new Pair('b', b));
        if (c > 0) pq.add(new Pair('c', c));

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {

            Pair first = pq.poll();

            int len = result.length();

            if (len >= 2 &&
                result.charAt(len - 1) == first.ch &&
                result.charAt(len - 2) == first.ch) {

                if (pq.isEmpty()) break;

                Pair second = pq.poll();

                result.append(second.ch);
                second.count--;

                if (second.count > 0)
                    pq.add(second);

                pq.add(first);
            }
            else {
                result.append(first.ch);
                first.count--;

                if (first.count > 0)
                    pq.add(first);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        char a = 7; 
        char b = 1; 
        char c = 1;

        System.out.println(longestDiverseString(a, b, c));
    }
}
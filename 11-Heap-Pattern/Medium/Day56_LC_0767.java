import java.util.*;

public class Day56_LC_0767 {
    static class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static String reorganizeString(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (Character key : map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
        }

        StringBuilder result = new StringBuilder();

        while (pq.size() > 1) {

        Pair a = pq.poll();
        Pair b = pq.poll();

        result.append(a.ch);
        result.append(b.ch);

        if (--a.freq > 0) pq.offer(a);
        if (--b.freq > 0) pq.offer(b);
        }

        if (!pq.isEmpty()) {
        Pair last = pq.poll();
        if (last.freq > 1) return "";
        result.append(last.ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "aab";

        System.out.println(reorganizeString(str));
    }
}
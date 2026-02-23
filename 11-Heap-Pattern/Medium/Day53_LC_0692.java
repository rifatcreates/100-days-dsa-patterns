import java.util.*;

public class Day53_LC_0692 {
    public static class Pair {
        int freq;
        String word;

        Pair(int freq, String word) {
            this.freq = freq;
            this.word = word;
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq)
                return a.freq - b.freq;          // smaller freq first
            return b.word.compareTo(a.word);    // reverse lexicographical
        });

        for (String key : map.keySet()) {
            pq.add(new Pair(map.get(key), key));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        String result[] = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().word;
        }

        return Arrays.asList(result);
    }

    public static void main(String[] args) {
        String words[] = {"i", "love", "leetcode", "i", "love", "coding"}; 
        int k = 2;

        List<String> result = topKFrequent(words, k);
        for (String word : result) {
            System.out.print(word + " ");
        }
    }
}
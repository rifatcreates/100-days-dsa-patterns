import java.util.*;

public class Day52_LC_0347 {
    public static class Pair {
        int freq;
        int num;

        Pair(int freq, int num) {
            this.freq = freq;
            this.num = num;
        }
    }

    public static int[] topKFrequent(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a != b) return a.freq - b.freq;
            return a.num - b.num;
        });

        for (Integer key : map.keySet()) {
            pq.add(new Pair(map.get(key), key));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int result[] = new int[k];
        for (int i=k-1; i>=0; i--) {
            result[i] = pq.poll().num;
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 2, 3}; 
        int k = 2;

        int result[] = topKFrequent(nums, k);
        for (int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
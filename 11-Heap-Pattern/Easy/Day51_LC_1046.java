import java.util.*;

public class Day51_LC_1046 {
    public static int lastStoneWeight(int stones[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i=0; i<stones.length; i++) {
            pq.add(stones[i]);
        }

        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            if (stone1 == stone2) {
                continue;
            }

            pq.add(stone1 - stone2);
        }

        return pq.size() == 0? 0 : pq.peek();
    }

    public static void main(String[] args) {
        int stones[] = {2, 7, 4, 1, 8, 1};

        System.out.println(lastStoneWeight(stones));
    }
}
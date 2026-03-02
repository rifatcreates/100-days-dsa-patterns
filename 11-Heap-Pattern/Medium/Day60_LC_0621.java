import java.util.*;

public class Day60_LC_0621 {
    public static int leastInterval(char tasks[], int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        pq.addAll(map.values());

        int time = 0;

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;
            int workDone = 0;

            for (int i = 0; i < cycle && !pq.isEmpty(); i++) {
                int freq = pq.poll();
                freq--;
                workDone++;

                if (freq > 0)
                    temp.add(freq);
            }

            for (int t : temp)
                pq.offer(t);

            if (pq.isEmpty())
                time += workDone;
            else
                time += cycle;
        }

        return time;
    }

    public static void main(String[] args) {
        char tasks[] = {'A','A','A','B','B','B'}; 
        int n = 2;

        System.out.println(leastInterval(tasks, n));
    }
}
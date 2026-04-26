import java.util.*;

public class Day112_LC_0743 {
    public static int networkDelayTime(int times[][], int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int from = edge[0];
            int to   = edge[1];
            int time = edge[2];
            graph.get(from).add(new int[]{to, time});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[k] = 0;  

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();  
            int currDist = current[0];       
            int currNode = current[1];       

            if (currDist > dist[currNode]) continue;

            for (int[] neighbor : graph.get(currNode)) {
                int nextNode = neighbor[0];
                int edgeTime = neighbor[1];

                int newDist = currDist + edgeTime;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new int[]{newDist, nextNode});
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }

    public static void main(String args[]) {
        int times[][] = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}; 
        int n = 4; 
        int k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }
}
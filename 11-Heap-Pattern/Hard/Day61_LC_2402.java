import java.util.*;

public class Day61_LC_2402 {
    public static int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Long.compare(a[0], b[0]));

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];

            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                count[room]++;
                busyRooms.offer(new long[]{end, room});
            } else {
                long[] earliest = busyRooms.poll();
                long newEnd = earliest[0] + (end - start);
                int room = (int) earliest[1];
                count[room]++;
                busyRooms.offer(new long[]{newEnd, room});
            }
        }

        int result = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[result]) {
                result = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 2; 
        int meetings[][] = {{0, 10}, {1, 5}, {2, 7}, {3, 4}};

        System.out.println(mostBooked(n, meetings));
    }   
}
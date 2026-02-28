import java.util.*;

public class Day58_LC_1942 {
    public static int smallestChair(int times[][], int targetFriend) {
        int targetArrival = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> free = new PriorityQueue<>();

        int chair = 0;

        for (int i = 0; i < times.length; i++) {

            int arrival = times[i][0];
            int leave = times[i][1];

            while (!occupied.isEmpty()
                && occupied.peek()[0] <= arrival) {
                free.add(occupied.poll()[1]);
            }

            int assignedChair;

            if (!free.isEmpty()) {
                assignedChair = free.poll();
            }
            else {
                assignedChair = chair++;
            }

            if (arrival == targetArrival) {
                return assignedChair;
            }

            occupied.add(new int[]{leave, assignedChair});
        }

        return -1;
    }

    public static void main(String[] args) {
        int times[][] = {{1, 4}, {2, 3}, {4, 6}};
        int targetFriend = 1;

        System.out.println(smallestChair(times, targetFriend));
    }
}
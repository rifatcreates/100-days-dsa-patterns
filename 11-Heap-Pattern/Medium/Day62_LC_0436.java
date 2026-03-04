import java.util.*;

public class Day62_LC_0436 {
    public static int[] findRightInterval(int intervals[][]) {
        int n = intervals.length;
        int[] result = new int[n];
        
        PriorityQueue<int[]> startHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        
        PriorityQueue<int[]> endHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        
        for (int i = 0; i < n; i++) {
            startHeap.offer(new int[]{intervals[i][0], i});
            endHeap.offer(new int[]{intervals[i][1], i});
        }
        
        while (!endHeap.isEmpty()) {
            
            int[] currentEnd = endHeap.poll();
            int endValue = currentEnd[0];
            int endIndex = currentEnd[1];
            
            int[] possibleStart = null;
            
            while (!startHeap.isEmpty() && startHeap.peek()[0] < endValue) {
                startHeap.poll();
            }
            
            if (!startHeap.isEmpty()) {
                possibleStart = startHeap.peek();
                result[endIndex] = possibleStart[1];
            } else {
                result[endIndex] = -1;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int intervals[][] = {{3, 4}, {2, 3}, {1, 2}};

        int[] answer = findRightInterval(intervals);

        System.out.println("Output:");
        for (int num : answer) {
            System.out.print(num + " ");
        }
    }
}
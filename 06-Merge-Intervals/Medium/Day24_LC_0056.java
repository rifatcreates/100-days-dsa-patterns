import java.util.*;

public class Day24_LC_0056 {
    public static void printArray(int arr[][]) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i][0] + ", " + arr[i][1] + "]");
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[][] merge(int intervals[][]) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for (int i=1; i<intervals.length; i++) {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if (end1 >= start2) {
                end1 = Math.max(end1, end2);
                continue;
            }

            result.add(new int[] {start1, end1});
            start1 = start2;
            end1 = end2;
        }

        result.add(new int[] {start1, end1});
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String args[]) {
        int intervals[][] = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18},
        };

        int mergedArray[][] = merge(intervals);
        printArray(mergedArray);
    }
}
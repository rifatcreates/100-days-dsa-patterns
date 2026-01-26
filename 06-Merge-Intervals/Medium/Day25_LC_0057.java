import java.util.*;

public class Day25_LC_0057 {
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

        List<int[]> merge = new ArrayList<>();

        int s1 = intervals[0][0];
        int e1 = intervals[0][1];

        for (int i=1; i<intervals.length; i++) {
            int s2 = intervals[i][0];
            int e2 = intervals[i][1];

            if (e1 >= s2) {
                e1 = Math.max(e1, e2);
                continue;
            }

            merge.add(new int[] {s1, e1});
            s1 = s2;
            e1 = e2;
        }

        merge.add(new int[] {s1, e1});
        return merge.toArray(new int[merge.size()][]);
    }

    public static int[][] insert(int intervals[][], int newInterval[]) {
        int newArr[][] = new int[intervals.length+1][2];

        for (int i=0; i<intervals.length; i++) {
            newArr[i] = intervals[i];
        }

        newArr[intervals.length] = newInterval;

        return merge(newArr);
    }

    public static void main(String args[]) {
        int intervals[][] = {
            {1, 3},
            {6, 9},
        };

        int newInterval[] = {2, 5};

        int result[][] = insert(intervals, newInterval);
        printArray(result);
    }
}
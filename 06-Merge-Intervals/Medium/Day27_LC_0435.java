import java.util.*;

public class Day27_LC_0435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int s1 = intervals[0][0];
        int e1 = intervals[0][1];
        int count = 0;

        for (int i=1; i<intervals.length; i++) {
            int s2 = intervals[i][0];
            int e2 = intervals[i][1];

            if (e1 > s2) {
                count++;
                e1 = Math.min(e1, e2);
            } else {
                e1 = e2;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int intervals[][] = {
            {1, 2},
            {2, 3},
            {3, 4},
            {1, 3}
        };

        System.out.println(eraseOverlapIntervals(intervals));
    }
}
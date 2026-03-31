import java.util.*;

public class Day89_LC_1288 {
    public static int removeCoveredIntervals(int intervals[][]) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];

        int count = 0;

        for (int i=1; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start >= currentStart && end <= currentEnd) {
                count++;
            } else if (start >= currentStart && end > currentEnd) {
                currentEnd = end;
            } else if (start > currentEnd) {
                currentStart = start;
                currentEnd = end;
            }
        }

        return intervals.length - count;
    }

    public static void main(String args[]) {
        int intervals[][] = {{1, 4}, {3, 6}, {2, 8}};

        System.out.println(removeCoveredIntervals(intervals));
    }
}
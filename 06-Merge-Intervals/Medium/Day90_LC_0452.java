import java.util.*;

public class Day90_LC_0452 {
    public static int findMinArrowShots(int points[][]) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));

        int arrow = 1;
        int arrowPosition = points[0][1];

        for (int i=1; i<points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];

            if (start > arrowPosition) {
                arrow++;
                arrowPosition = end;
            }
        }

        return arrow;
    }

    public static void main(String args[]) {
        int points[][] = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};

        System.out.println(findMinArrowShots(points));
    }
}
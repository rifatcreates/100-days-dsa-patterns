import java.util.*;

public class Day27_GFG_Overlapping_Intervals {
    public static boolean isOverlap(int n, int arr[][]) {
        if (n <= 1) {
            return false;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int s1 = arr[0][0];
        int e1 = arr[0][1];

        for (int i=1; i<arr.length; i++) {
            int s2 = arr[i][0];
            int e2 = arr[i][1];

            if (e1 >= s2) {
                return true;
            }

            e1 = Math.max(e1, e2);
        }

        return false;
    }

    public static void main(String args[]) {
        int n = 4;

        int arr[][] = {
            {1, 3},
            {5, 7},
            {2, 4},
            {6, 8},
        };

        System.out.println(isOverlap(n, arr));
    }
}
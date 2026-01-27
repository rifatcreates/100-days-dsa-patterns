import java.util.*;

public class Day26_LC_0986 {
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

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List <int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {
            int s1 = firstList[i][0];
            int e1 = firstList[i][1];
            int s2 = secondList[j][0];
            int e2 = secondList[j][1];

            if (s1 <= s2) {
                if (e1 >= s2) {
                    int s = Math.max(s1, s2);
                    int e = Math.min(e1, e2);
                    res.add(new int[] {s, e});
                }
            } else {
                if (e2 >= s1) {
                    int s = Math.max(s1, s2);
                    int e = Math.min(e1, e2);
                    res.add(new int[] {s, e});
                }
            }

            if (e1 <= e2) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String args[]) {
        int firstList[][] = {
            {0, 2},
            {5, 10},
            {13, 23},
            {24, 25},
        };

        int secondList[][] = {
            {1, 5},
            {8, 12},
            {15, 24},
            {25, 26},
        };

        int result[][] = intervalIntersection(firstList, secondList);
        printArray(result);
    }
}
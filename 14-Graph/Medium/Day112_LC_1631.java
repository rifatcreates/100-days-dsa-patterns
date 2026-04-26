import java.util.*;

public class Day112_LC_1631 {
    public static int minimumEffortPath(int heights[][]) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] effort = new int[rows][cols];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;  

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0] 
        );

        pq.offer(new int[]{0, 0, 0});

        int[][] dirs = {
            {-1,  0}, 
            { 1,  0},   
            { 0, -1},   
            { 0,  1}    
        };

        while (!pq.isEmpty()) {

            int[] current  = pq.poll();
            int currEffort = current[0];
            int currRow    = current[1];
            int currCol    = current[2];

            if (currRow == rows - 1 && currCol == cols - 1) {
                return currEffort;
            }

            if (currEffort > effort[currRow][currCol]) continue;

            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];

                if (nextRow < 0 || nextRow >= rows ||
                    nextCol < 0 || nextCol >= cols) {
                    continue;
                }

                int diff = Math.abs(
                    heights[currRow][currCol] - heights[nextRow][nextCol]
                );

                int newEffort = Math.max(currEffort, diff);

                if (newEffort < effort[nextRow][nextCol]) {
                    effort[nextRow][nextCol] = newEffort;
                    pq.offer(new int[]{newEffort, nextRow, nextCol});
                }
            }
        }

        return effort[rows - 1][cols - 1];
    }

    public static void main(String args[]) {
        int heights[][] = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        System.out.println(minimumEffortPath(heights));
    }
}
import java.util.*;

public class Day116_LC_0120 {
    public static int solve(int row, int col, List<List<Integer>> triangle, int[][] memo) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        if (memo[row][col] != -10001) {
            return memo[row][col];
        }

        int down = solve(row + 1, col, triangle, memo);
        int downRight = solve(row + 1, col + 1, triangle, memo);

        memo[row][col] = triangle.get(row).get(col) + Math.min(down, downRight);
        
        return memo[row][col];
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -10001);
        }
        
        return solve(0, 0, triangle, memo);
    }

    public static void main(String args[]) {
        List<List<Integer>> triangle = List.of(
            List.of(2),
            List.of(3, 4),
            List.of(6, 5, 7),
            List.of(4, 1, 8, 3)
        );

        System.out.println(minimumTotal(triangle));
    }
}
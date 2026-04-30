import java.util.*;

public class Day116_LC_0064 {
    public static int solve(int i, int j, int[][] grid, int[][] memo) {
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int right = solve(i, j + 1, grid, memo);
        int down = solve(i + 1, j, grid, memo);

        memo[i][j] = grid[i][j] + Math.min(right, down);
        
        return memo[i][j];
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return solve(0, 0, grid, memo);
    }

    public static void main(String args[]) {
        int grid[][] = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println(minPathSum(grid));
    }
}
import java.util.*;

public class Day101_LC_0200 {
    public static void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '2';

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }


    public static int numIslands(char grid[][]) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == '1') {
                    count++;                 
                    dfs(grid, row, col);     
                }
            }
        }

        return count;
    }

    public static void main(String args[]) {
        char grid[][] = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        System.out.println(numIslands(grid));
    }
}
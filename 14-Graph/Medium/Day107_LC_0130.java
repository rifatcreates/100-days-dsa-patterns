import java.util.*;

public class Day107_LC_0130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        int rows = board.length, cols = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') queue.add(new int[]{0, j});
            if (board[rows-1][j] == 'O') queue.add(new int[]{rows-1, j});
        }
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') queue.add(new int[]{i, 0});
            if (board[i][cols-1] == 'O') queue.add(new int[]{i, cols-1});
        }
        
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1];
            if (board[i][j] != 'O') continue;
            
            board[i][j] = 'S';
            
            for (int[] dir : dirs) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && board[ni][nj] == 'O') {
                    queue.add(new int[]{ni, nj});
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }
    
    public static void printBoard(char[][] board) {
        System.out.println("Output Board:");
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print("\"" + board[i][j] + "\"");
                if (j < board[0].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            if (i < board.length - 1) {
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        
        System.out.println("Input Board:");
        printBoard(board);
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        Day107_LC_0130 solution = new Day107_LC_0130();
        solution.solve(board);
        
        printBoard(board);
    }
}
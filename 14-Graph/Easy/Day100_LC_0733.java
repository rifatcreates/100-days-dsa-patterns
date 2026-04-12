import java.util.*;

public class Day100_LC_0733 {
    public static void dfs(int image[][], int row, int col, int oldColor, int newColor) {
        if (row < 0 || row >= image.length ||
            col < 0 || col >= image[0].length ||
            image[row][col] != oldColor) {
            return;
        }

        image[row][col] = newColor;

        dfs(image, row - 1, col, oldColor, newColor); 
        dfs(image, row + 1, col, oldColor, newColor); 
        dfs(image, row, col - 1, oldColor, newColor); 
        dfs(image, row, col + 1, oldColor, newColor); 
    }

    public static int[][] floodFill(int image[][], int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }

        dfs(image, sr, sc, image[sr][sc], color);

        return image;
    }

    public static void main(String args[]) {
        int image[][] = {{1, 1, 1},
                         {1, 1, 0},
                         {1, 0, 1}}; 
        
        int sr = 1; 
        int sc = 1; 
        int color = 2;

        int[][] result = floodFill(image, sr, sc, color);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
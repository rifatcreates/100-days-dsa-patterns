import java.util.*;

public class Day105_LC_0994 {
    public static int orangesRotting(int grid[][]) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        int minutes = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                
                if(grid[i][j] == 1) {
                    freshCount++;
                }
                else if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        if(freshCount == 0) {
            return 0;
        }
        
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                
                for(int[] dir : directions) {
                    
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if(newRow >= 0 && newRow < grid.length && 
                       newCol >= 0 && newCol < grid[0].length) {
                        
                        if(grid[newRow][newCol] == 1) {
                            grid[newRow][newCol] = 2;
                            queue.add(new int[]{newRow, newCol});
                            freshCount--;
                        }
                    }
                }
            }
            
            if(!queue.isEmpty()) {
                minutes++;
            }
        }
        
        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String args[]) {
        int grid[][] = {{2, 1, 1},
                        {1, 1, 0},
                        {0, 1, 1}};

        System.out.println(orangesRotting(grid));
    }
}
import java.util.*;

public class Day110_LC_2360 {
    public static int longestCycle(int edges[]) {
        int n = edges.length;
        boolean[] visited = new boolean[n];  
        int[] time = new int[n];             
        int longest = -1;                 
        int currentTime = 1;             
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int node = i;
                int startTime = currentTime;
                
                while (node != -1 && !visited[node]) {
                    visited[node] = true;     
                    time[node] = currentTime; 
                    currentTime++;
                    node = edges[node]; 
                }
                
                if (node != -1 && time[node] >= startTime) {
                    int cycleLength = currentTime - time[node];
                    longest = Math.max(longest, cycleLength);
                }
            }
        }
        
        return longest;
    }

    public static void main(String args[]) {
        int edges[] = {3, 3, 4, 2, 3};

        System.out.println(longestCycle(edges));
    }
}
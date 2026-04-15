import java.util.*;

public class Day102_LC_1971 {
    public static boolean hasPath(List<List<Integer>> graph, int source, int destination, boolean visited[]) {
        if (source == destination) {
            return true;
        }

        visited[source] = true;

        for (int neighbour : graph.get(source)) {
            if (!visited[neighbour]) {
                if (hasPath(graph, neighbour, destination, visited)) {
                    return true;
                }
            }
        }

        return false;     
    }

    public static boolean validPath(int n, int edges[][], int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return hasPath(graph, source, destination, new boolean[n]);
    }

    public static void main(String args[]) {
        int n = 3; 
        int edges[][] = {{0, 1}, {1, 2}, {2, 0}}; 
        int source = 0; 
        int destination = 2;

        System.out.println(validPath(n, edges, source, destination));
    }
}
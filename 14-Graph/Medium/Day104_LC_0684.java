import java.util.*;

public class Day104_LC_0684 {

    static List<List<Integer>> adj;

    public static boolean dfs(int src, int dest, boolean[] visited) {
        if (src == dest) return true;

        visited[src] = true;

        for (int neighbor : adj.get(src)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, dest, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[n + 1];

            if (dfs(u, v, visited)) {
                return edge;
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[]{};
    }

    public static void main(String[] args) {

        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};

        int[] result = findRedundantConnection(edges);

        System.out.println("Redundant Edge: [" + result[0] + ", " + result[1] + "]");
    }
}
import java.util.*;

public class Day103_LC_0207 {
    public static boolean hasCycle(List<List<Integer>> graph, int curr, boolean visited[], boolean stack[]) {
        if (stack[curr]) {
            return true;
        }

        if (visited[curr]) {
            return false;
        }

        stack[curr] = true;
        visited[curr] = true;

        for (int neighbour : graph.get(curr)) {
            if (hasCycle(graph, neighbour, visited, stack)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }

    public static boolean canFinish(int numCourses, int prerequisites[][]) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int prerequisite[] : prerequisites) {
            int u = prerequisite[0];
            int v = prerequisite[1];

            graph.get(u).add(v);
        }

        boolean visited[] = new boolean[numCourses];
        boolean stack[] = new boolean[numCourses];

        for (int i=0; i<numCourses; i++) {
            if (hasCycle(graph, i, visited, stack)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        int numCourses = 2; 
        int prerequisites[][] = {{1, 0}};

        System.out.println(canFinish(numCourses, prerequisites));
    }
}
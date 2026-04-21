import java.util.*;

public class Day108_LC_0210 {
    public static void printResult(int numCourses, int[][] prerequisites) {
        int[] order = findOrder(numCourses, prerequisites);
        
        if (order.length == 0) {
            System.out.println("No possible ordering (Cycle detected).");
        } else {
            System.out.print("Course order: ");
            for (int course : order) {
                System.out.print(course + " ");
            }
            System.out.println();
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int count = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result[count++] = current;

            for (int neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return count == numCourses ? result : new int[0];
    }
    
    public static void main(String[] args) {
        int numCourses = 2; 
        int prerequisites[][] = {{1, 0}};

        printResult(numCourses, prerequisites);
    }
}
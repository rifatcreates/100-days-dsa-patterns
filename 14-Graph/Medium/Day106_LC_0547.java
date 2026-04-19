import java.util.*;

public class Day106_LC_0547 {
    public static void dfs(int isConnected[][], boolean isVisited[], int city) {
        isVisited[city] = true;

        for (int i=0; i<isConnected.length; i++) {
            if (isConnected[city][i] == 1 && !isVisited[i]) {
                dfs(isConnected, isVisited, i);
            }
        }
    }

    public static int findCircleNum(int isConnected[][]) {
        boolean isVisited[] = new boolean[isConnected.length];
        int provinces = 0;

        for (int i=0; i<isConnected.length; i++) {
            if (!isVisited[i]) {
                dfs(isConnected, isVisited, i);
                provinces++;
            }
        }

        return provinces;
    }

    public static void main(String args[]) {
        int isConnected[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(findCircleNum(isConnected));
    }
}
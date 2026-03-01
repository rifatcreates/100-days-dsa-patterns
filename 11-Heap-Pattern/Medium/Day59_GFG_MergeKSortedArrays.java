import java.util.*;

public class Day59_GFG_MergeKSortedArrays {
    public static class Node {
        int value;
        int row;
        int col;

        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public static ArrayList<Integer> mergeArrays(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

        for (int i=0; i<n; i++) {
            pq.add(new Node(mat[i][0], i, 0));
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {

            Node nd = pq.poll(); 

            int v = nd.value;
            int r = nd.row;
            int c = nd.col;

            res.add(v);

            if (c+1 < m) {
                pq.add(new Node(mat[r][c+1], r, c+1));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 3, 5, 7},
                       {2, 4, 6, 8}, 
                       {0, 9, 10, 11}};

        System.out.println(mergeArrays(mat));
    }   
}
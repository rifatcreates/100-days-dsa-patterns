import java.util.*;

class Day86_LC_1074 {
    public static int subarraySum(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix = 0;
        int count = 0;

        for (int num : nums) {
            prefix += num;

            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

    public static int numSubmatrixSumTarget(int matrix[][], int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int count = 0;

        for (int top = 0; top < rows; top++) {

            int[] colSum = new int[cols];

            for (int bottom = top; bottom < rows; bottom++) {

                for (int c = 0; c < cols; c++) {
                    colSum[c] += matrix[bottom][c];
                }

                count += subarraySum(colSum, target);
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int matrix[][] = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}; 
        int target = 0;

        System.out.println(numSubmatrixSumTarget(matrix, target));
    }
}
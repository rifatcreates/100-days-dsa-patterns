public class Day48_LC_0240 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                row--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,4,7,11,15},
                          {2,5,8,12,19},
                          {3,6,9,16,22},
                          {10,13,14,17,24},
                          {18,21,23,26,30}};

        int target = 5;

        System.out.println(searchMatrix(matrix, target));
    }
}
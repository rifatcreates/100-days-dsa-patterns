public class Day47_LC_0074 {
    public static boolean searchMatrix(int matrix[][], int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = (m * n) - 1;

        while (low <= high) {
            int guess = (low + high) / 2;
            int row = guess / n;
            int col = guess % n;

            if(matrix[row][col] < target) {
                low = guess+1;
            } else if(matrix[row][col] > target) {
                high = guess-1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 3, 5, 7},
                         {10, 11, 16, 20},
                         {23, 30, 34, 60}};
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }
}
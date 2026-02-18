public class Day48_LC_0378 {
    public static int helper(int matrix[][], int guess) {
        int row = matrix.length-1;
        int col = 0;
        int count = 0;

        while (row >= 0 && col < matrix[0].length) {

            if (matrix[row][col] > guess) {
                row--;
            } else {
                count += row+1;
                col++;
            }
        }

        return count;
    }

    public static int kthSmallest(int matrix[][], int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix[0].length-1];
        int res = -1;

        while (low <= high) {
            int guess = (low + high) / 2;
            int smallerThanGuess = helper(matrix, guess);

            if (smallerThanGuess < k) {
                low = guess+1;
            } else {
                res = guess;
                high = guess-1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 5, 9},
                          {10, 11, 13},
                          {12, 13, 15}};

        int k = 8;

        System.out.println(kthSmallest(matrix, k));
    }
}
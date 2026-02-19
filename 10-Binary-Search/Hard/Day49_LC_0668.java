public class Day49_LC_0668 {
    public static int helper(int m, int n, int guess) {
        int count = 0;

        for (int i=1; i<=m; i++) {
            count += Math.min(n, guess / i);
        }

        return count;
    }

    public static int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        int res = 0;

        while (low <= high) {
            int guess = (low + high) / 2;
            int smallerThanGuess = helper(m, n, guess);

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
        int m = 3; 
        int n = 3; 
        int k = 5;

        System.out.println(findKthNumber(m, n, k));
    }
}
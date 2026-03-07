public class Day65_LC_0070 {
    public static int helper(int n, int[] memo) {
        if (n <= 2) return n;

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }

    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }

    public static void main(String args[]) {
        int n = 3;
        System.out.println(climbStairs(n));
    }
}
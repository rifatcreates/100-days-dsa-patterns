import java.util.*;

public class Day114_LC_0746 {
    public static int helper(int cost[], int i, int dp[]) {
        if (i < 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = cost[i] + Math.min(helper(cost, i-1, dp), helper(cost, i-2, dp));
        return dp[i];
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return Math.min(helper(cost, n-1, dp), helper(cost, n-2, dp));
    }

    public static void main(String args[]) {
        int cost[] = {10, 15, 20};

        System.out.println(minCostClimbingStairs(cost));
    }
}
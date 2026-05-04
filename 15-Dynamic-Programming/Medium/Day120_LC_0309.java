import java.util.*;

public class Day120_LC_0309 {
    public static int solve(int i, int buying, int[] prices, int[][] memo) {
        if (i >= prices.length) {
            return 0;
        }

        if (memo[i][buying] != -1) {
            return memo[i][buying];
        }

        int cooldown = solve(i + 1, buying, prices, memo);

        if (buying == 1) {
            int buy = -prices[i] + solve(i + 1, 0, prices, memo);
            
            memo[i][buying] = Math.max(buy, cooldown);
        } else {
            int sell = prices[i] + solve(i + 2, 1, prices, memo);
            
            memo[i][buying] = Math.max(sell, cooldown);
        }

        return memo[i][buying];
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n][2];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return solve(0, 1, prices, memo);
    }

    public static void main(String args[]) {
        int prices[] = {1, 2, 3, 0, 2};

        System.out.println(maxProfit(prices));
    }
}
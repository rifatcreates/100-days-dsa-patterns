import java.util.*;

public class Day117_LC_0322 {
    public static int solve(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        
        if (amount < 0) return Integer.MAX_VALUE;

        if (memo[amount] != -1) return memo[amount];

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = solve(coins, amount - coin, memo);
            
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + res);
            }
        }

        memo[amount] = minCoins;
        return memo[amount];
    }

    public static int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        
        int result = solve(coins, amount, memo);
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String args[]) {
        int coins[] = {1, 2, 5}; 
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }
}
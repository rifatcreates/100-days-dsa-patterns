import java.util.*;

public class Day114_LC_0198 {
    public static int solve(int[] nums, int i, int[] memo) {
        if (i >= nums.length) return 0;
        
        if (memo[i] != -1) return memo[i];
        
        int rob = nums[i] + solve(nums, i + 2, memo);
        
        int skip = solve(nums, i + 1, memo);
        
        memo[i] = Math.max(rob, skip);
        return memo[i];
    }

    public static int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return solve(nums, 0, memo);
    }

    public static void main(String args[]) {
        int nums[] = {1, 2, 3, 1};

        System.out.println(rob(nums));
    }
}
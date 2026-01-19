import java.util.*;

public class Day19_LC_0152 {
    public static int maxProduct(int[] nums) {
        int maxEnding = nums[0];
        int minEnding = nums[0];
        int ans = nums[0];

        for (int i=1; i<nums.length; i++) {
            int v1 = nums[i];
            int v2 = nums[i] * maxEnding;
            int v3 = nums[i] * minEnding;

            maxEnding = Math.max(v1, Math.max(v2, v3));
            minEnding = Math.min(v1, Math.min(v2, v3));
            ans = Math.max(ans, Math.max(maxEnding, minEnding));
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = {2,3,-2,4};

        System.out.println(maxProduct(nums));
    }
}
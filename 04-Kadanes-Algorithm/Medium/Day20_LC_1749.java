import java.util.*;

public class Day20_LC_1749 {
    public static int maxAbsoluteSum(int nums[]) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int res = Math.abs(nums[0]);

        for (int i=1; i<nums.length; i++) {
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            minSum = Math.min(minSum + nums[i], nums[i]);

            int absMaxSum = Math.abs(maxSum);
            int absMinSum = Math.abs(minSum);

            res = Math.max(res, Math.max(absMaxSum, absMinSum));
        }

        return res;
    }

    public static void main(String args[]) {
        int nums[] = {1,-3,2,3,-4};

        System.out.println(maxAbsoluteSum(nums));
    }
}
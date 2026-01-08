import java.util.*;

public class Day08_MinSubArrayLen {
    public static int minSubArrayLen(int nums[], int target) {
        int low = 0;
        int high = 0;
        int currentSum = 0;
        int res = Integer.MAX_VALUE;

        while (high < nums.length) {
            currentSum += nums[high];

            while (currentSum >= target) {
                int sum = high - low + 1;
                res = Math.min(res, sum);
                currentSum -= nums[low];
                low++;
            }
            
            high++;
        }

        if (res == Integer.MAX_VALUE) {
            return 0;
        }

        return res;
    }

    public static void main(String args[]) {
        int nums[] = {2,3,1,2,4,3};
        int target = 7;

        System.out.println(minSubArrayLen(nums,target));
    }
}
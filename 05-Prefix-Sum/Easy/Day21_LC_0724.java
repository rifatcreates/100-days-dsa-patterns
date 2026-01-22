import java.util.*;

public class Day21_LC_0724 {
    public static int sumOfArr(int[] nums) {
        int sum = 0;

        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }

    public static int pivotIndex(int nums[]) {
        int sum = sumOfArr(nums);
        int prefix = 0;
        int suffix = 0;

        for (int i=0; i<nums.length; i++) {
            suffix = sum - nums[i] - prefix;

            if (prefix == suffix) {
                return i;
            }

            prefix += nums[i];
        }

        return -1;
    }

    public static void main(String args[]) {
        int nums[] = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
}
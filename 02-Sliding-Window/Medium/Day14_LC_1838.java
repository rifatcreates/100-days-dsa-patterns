import java.util.*;

public class Day14_LC_1838 {
   
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int max = 0;
        int low = 0; 
        long sum = 0;

        for (int high=0; high<nums.length; high++) {
            sum += nums[high];

            while ((long)nums[high] * (high-low+1) - sum > k) {
                sum -= nums[low];
                low++;
            }

            max = Math.max(max, high-low+1);
        }

        return max;
    }

    public static void main(String args[]) {
        int nums[] = {1,2,4}; 
        int k = 5;

        System.out.println(maxFrequency(nums, k));
    }
}
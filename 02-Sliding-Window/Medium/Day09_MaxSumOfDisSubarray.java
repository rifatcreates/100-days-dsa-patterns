import java.util.*;

public class Day09_MaxSumOfDisSubarray {
    public static long maxSumSubarray(int nums[], int k) {
        int low = 0;
        long currentSum = 0;
        long maxSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int high = 0; high < nums.length; high++) {

            map.put(nums[high], map.getOrDefault(nums[high], 0) + 1);
            currentSum += nums[high];

            if (high - low + 1 > k) {
                int leftVal = nums[low];
                map.put(leftVal, map.get(leftVal) - 1);
                currentSum -= leftVal;

                if (map.get(leftVal) == 0) {
                    map.remove(leftVal);
                }

                low++;
            }

            if (high - low + 1 == k && map.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    public static void main(String args[]) {
        int nums[] = {1,5,4,2,9,9,9}; 
        int k = 3;

        System.out.println(maxSumSubarray(nums, k));
    }
}
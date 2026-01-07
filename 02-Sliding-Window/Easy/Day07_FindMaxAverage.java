import java.util.*;

public class Day07_FindMaxAverage {
    public static double findMaxAverage(int nums[], int k) {
        int low = 0;
        int high = 0;
        int windowSum = 0;

        for (high = 0; high < k; high++) {
            windowSum += nums[high];
        }

        int maxSum = windowSum;

        while (high < nums.length) {

            windowSum += nums[high];
            windowSum -= nums[low];

            low++;
            high++;

            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }

    public static void main(String args[]) {
        int nums[] = {1,12,-5,-6,50,3}; 
        int k = 4;

        System.out.println(findMaxAverage(nums, k));
    }
}
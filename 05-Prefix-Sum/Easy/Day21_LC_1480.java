import java.util.*;

public class Day21_LC_1480 {
    public static void printArr(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] runningSum(int nums[]) {
        int prefix[] = new int[nums.length];
        prefix[0] = nums[0];

        for (int i=1; i<prefix.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        return prefix;
    }

    public static void main(String args[]) {
        int nums[] = {1,2,3,4};

        int prefix[] = runningSum(nums);
        printArr(prefix);
    }
}
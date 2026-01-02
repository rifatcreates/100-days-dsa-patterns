import java.util.*;

public class Day02_SortedSquares {
    public static int[] sortedSquares(int nums[]) {
        int res[] = new int[nums.length];

        int i = 0;
        int j = nums.length-1;
        int k = nums.length-1;

        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[k] = nums[i] * nums[i];
                i++;
            } else {
                res[k] = nums[j] * nums[j];
                j--;
            }

            k--;
        }

        return res;
    }
    public static void main(String args[]) {
        int nums[] = {-4,-1,0,3,10};

        int result[] = sortedSquares(nums);

        for (int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
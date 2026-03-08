import java.util.*;

public class Day66_LC_0018 {
    public static List<List<Integer>> fourSum(int nums[], int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for (int i=0; i<n-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            for (int j=i+1; j<n-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;

                int left = j+1;
                int right = n-1;

                while (left < right) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];

                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        int leftVal = nums[left];
                        int rightVal = nums[right];

                        while (left < right && nums[left] == leftVal) left++;
                        while (left < right && nums[right] == rightVal) right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = {1, 0, -1, 0, -2, 2}; 
        int target = 0;

        System.out.print(fourSum(nums, target));
    }
}
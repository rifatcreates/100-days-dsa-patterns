public class Day43_LC_0033 {
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int guess = (low + high)/2;

            if (nums[guess] == target) {
                return guess;
            }

            if (nums[guess] > nums[high]) {
                if (nums[guess] < target) {
                    low = guess+1;
                } else {
                    if (nums[low] > target) {
                        low = guess+1;
                    } else {
                        high = guess-1;
                    }
                }
            } else {
                if (nums[guess] > target) {
                    high = guess-1;
                } else {
                    if (nums[high] < target) {
                        high = guess-1;
                    } else {
                        low = guess+1;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2}; 
        int target = 0;

        System.out.println(search(nums, target));
    }
}
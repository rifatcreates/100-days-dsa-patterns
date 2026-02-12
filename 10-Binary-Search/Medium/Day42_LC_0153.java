public class Day42_LC_0153 {
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while (low < high) {
            int guess = (low + high) / 2;

            if (nums[guess] > nums[high]) {
                low = guess + 1;
            } else {
                high = guess;
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
        int nums[] = {3, 4, 5, 1, 2};

        System.out.println(findMin(nums));
    }
}
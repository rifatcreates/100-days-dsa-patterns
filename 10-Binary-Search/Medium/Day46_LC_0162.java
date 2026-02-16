public class Day46_LC_0162 {
    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while (low < high) {
            int guess = (low + high) / 2;

            if (nums[guess] < nums[guess+1]) {
                low = guess+1;
            } else {
                high = guess;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};

        System.out.println(findPeakElement(nums));
    }
}
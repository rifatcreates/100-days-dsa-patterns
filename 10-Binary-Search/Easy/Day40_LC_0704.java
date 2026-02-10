public class Day40_LC_0704 {
    public static int search(int nums[], int target) {
        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int guess = (high + low) / 2;

            if (nums[guess] == target) {
                return guess;
            } else if (nums[guess] < target) {
                low = guess + 1;
            } else {
                high = guess - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {-1, 0, 3, 5, 9, 12}; 
        int target = 9;

        System.out.println(search(nums, target));
    }
}
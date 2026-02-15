public class Day45_LC_0035 {
    public static int searchInsert(int nums[], int target) {
        int low = 0;
        int high = nums.length-1;
        int res = nums.length;

        while (low <= high) {
            int guess = (low + high) / 2;

            if (nums[guess] >= target) {
                res = guess;
                high = guess-1;
            } else {
                low = guess+1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6}; 
        int target = 5;

        System.out.println(searchInsert(nums, target));
    }
}
public class Day41_LC_0034 {
    public static int findFirst(int nums[], int target) {
        int low = 0;
        int high = nums.length-1;
        int res = -1;

        while (low <= high) {
            int guess = (high + low) / 2;

            if (nums[guess] < target) {
                low = guess + 1;
            } else if (nums[guess] > target) {
                high = guess - 1;
            } else {
                res = guess;
                high = guess - 1;
            }
        }

        return res;
    }

    public static int findLast(int nums[], int target) {
        int low = 0;
        int high = nums.length-1;
        int res = -1;

        while (low <= high) {
            int guess = (high + low) / 2;

            if (nums[guess] < target) {
                low = guess + 1;
            } else if (nums[guess] > target) {
                high = guess - 1;
            } else {
                res = guess;
                low = guess + 1;
            }
        }

        return res;
    }

    public static int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1;

        if (nums.length == 0) {
            return res;
        }

        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {5, 7, 7, 8, 8, 10}; 
        int target = 8;

        int res[] = searchRange(nums, target);
        for (int i=0; i<res.length; i++) {
            System.out.print(res[i] + "," );
        }
    }
}
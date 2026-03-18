public class Day76_LC_0457 {
    public static int move(int nums[], int i, boolean isForward) {
        boolean direction = nums[i] > 0;

        if (direction != isForward) return -1;

        int n = nums.length;
        int next = ((i + nums[i]) % n + n) % n;

        if (next == i) return -1;

        return next;
    }

    public static boolean circularArrayLoop(int nums[]) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            boolean isForward = nums[i] > 0;
            int slow = i;
            int fast = i;

            while (true) {
                slow = move(nums, slow, isForward);
                if (slow == -1) break;

                fast = move(nums, fast, isForward);
                if (fast == -1) break;

                fast = move(nums, fast, isForward);
                if (fast == -1) break;

                if (slow == fast) return true;
            }

            int index = i;
            while (true) {
                int next = ((index + nums[index]) % n + n) % n;
                nums[index] = 0;

                if ((nums[next] > 0) != isForward || next == index) break;

                index = next;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        int nums[] = {2, -1, 1, 2, 2};

        System.out.println(circularArrayLoop(nums));
    }
}
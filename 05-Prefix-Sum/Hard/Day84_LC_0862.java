import java.util.*;

class Day84_LC_0862 {
    public static int shortestSubarray(int nums[], int k) {
        int n = nums.length;
        
        long prefix[] = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j <= n; j++) {
            
            while (!dq.isEmpty() && prefix[j] - prefix[dq.peekFirst()] >= k) {
                ans = Math.min(ans, j - dq.pollFirst());
            }

            while (!dq.isEmpty() && prefix[j] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.addLast(j);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String args[]) {
        int nums[] = {2, -1, 2}; 
        int k = 3;

        System.out.println(shortestSubarray(nums, k));
    }
}
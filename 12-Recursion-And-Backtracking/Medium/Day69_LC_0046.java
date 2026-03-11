import java.util.*;

public class Day69_LC_0046 {
    public static void helper(int nums[], List<List<Integer>> res, int curr[], boolean used[], int idx) {
        if (idx == nums.length) {
            List<Integer> permutation = new ArrayList<>();

            for (int num : curr) {
                permutation.add(num);
            }

            res.add(permutation);
        }

        for (int i=0; i<nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                curr[idx] = nums[i];
                helper(nums, res, curr, used, idx+1);
                used[i] = false;
            }
        }
    }
    
    public static List<List<Integer>> permute(int nums[]) {
        List<List<Integer>> res = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        helper(nums, res, new int[nums.length], used, 0);
        return res; 
    }
    
    public static void main(String args[]) {
        int nums[] = {1, 2, 3};

        System.out.print(permute(nums));
    }
}
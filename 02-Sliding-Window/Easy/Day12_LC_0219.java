import java.util.*;

public class Day12_LC_0219 {
    public static boolean containsNearbyDuplicate(int nums[], int k) {
        HashSet<Integer> set = new HashSet<>();
        int low = 0;

        for (int high = 0; high < nums.length; high++) {
            
            if (high - low > k) {
                set.remove(nums[low]);
                low++;
            }

            if (set.contains(nums[high])) {
                return true;
            }

            set.add(nums[high]);
        }

        return false;
    }

    public static void main(String args[]) {
        int nums[] = {1,2,3,1}; 
        int k = 3;

        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
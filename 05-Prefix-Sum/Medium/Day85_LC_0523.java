import java.util.*;

public class Day85_LC_0523 {
    public static boolean checkSubarraySum(int nums[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1);
        
        int prefix = 0;
        
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            
            int rem = prefix % k;
            
            if (rem < 0) rem += k;
            
            if (map.containsKey(rem)) {
                int prevIndex = map.get(rem);
                
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }
        
        return false;
    }

    public static void main(String args[]) {
        int nums[] = {23, 2, 4, 6, 7}; 
        int k = 6;

        System.out.println(checkSubarraySum(nums, k));
    }
}
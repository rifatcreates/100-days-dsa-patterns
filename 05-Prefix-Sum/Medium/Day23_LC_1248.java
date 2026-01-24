import java.util.*;

public class Day23_LC_1248 {
    public static int numberOfSubarrays(int nums[], int k) {
        int n = nums.length;
        
        int[] oddCountPrefix = new int[n];
        int currentOdd = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                currentOdd++;
            }
            oddCountPrefix[i] = currentOdd;
        }

        int[] freq = new int[n + 1];
        freq[0] = 1;
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int currentSum = oddCountPrefix[i];
            
            if (currentSum >= k) {
                count += freq[currentSum - k];
            }
            
            freq[currentSum]++;
        }

        return count;
    }

    public static void main(String args[]) {
        int nums[] = {1,1,2,1,1}; 
        int k = 3;

        System.out.println(numberOfSubarrays(nums, k));
    }
}
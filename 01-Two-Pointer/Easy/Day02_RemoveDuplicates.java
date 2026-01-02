import java.util.*;

public class Day02_RemoveDuplicates {
    public static int removeDuplicates(int nums[]) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 1;
        int j = 1;

        while (i < nums.length) {
            if (nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                j++;
            }

            i++;
        }

        return j;
    }

    public static void main(String args[]) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
import java.util.*;

public class Day04_SortColors {
    public static void sortColors(int nums[]) {
        int i = 0;
        int j = nums.length - 1;
        int k = 0;

        while (k <= j) {

            if (nums[k] == 0) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;

                i++;
                k++;
            } else if (nums[k] == 2) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;

                j--;
            } else {
                k++;
            }
        }
    }

    public static void main(String args[]) {
        int nums[] = {2,0,2,1,1,0};

        sortColors(nums);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
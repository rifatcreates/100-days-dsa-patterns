import java.util.*;

public class Day98_LC_0169 {
    public static int majorityElement(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int majorityCount = nums.length / 2;

        for (int num : map.keySet()) {
            int count = map.get(num);

            if (count > majorityCount) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int nums[] = {3, 2, 3};

        System.out.println(majorityElement(nums));
    }
}
import java.util.*;

public class Day06_ContainerWithMostWater {
    public static int maxArea(int height[]) {
        int maxWater = 0;

        int i = 0;
        int j = height.length - 1;

        while (i <= j) {

            if (height[i] < height[j]) {
                int ht = height[i];
                int wt = j - i;
                int area = ht * wt;

                maxWater = Math.max(maxWater, area);
                i++;
            } else {
                int ht = height[j];
                int wt = j - i;
                int area = ht * wt;

                maxWater = Math.max(maxWater, area);
                j--;
            }
        }

        return maxWater;
    }

    public static void main(String args[]) {
        int height[] = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));
    }
}
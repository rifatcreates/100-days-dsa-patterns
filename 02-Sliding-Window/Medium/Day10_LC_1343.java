import java.util.*;

public class Day10_LC_1343 {
    public static int numOfSubarrays(int arr[], int k, int threshold) {
        int count = 0;
        int sum = 0;

        for (int i=0; i<k; i++) {
            sum += arr[i];
        }

        if ((sum / k) >= threshold) {
            count++;
        }

        for (int i=k; i<arr.length; i++) {
            sum += arr[i];
            sum -= arr[i-k];

            if ((sum / k) >= threshold) {
                count++;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int arr[] = {2,2,2,2,5,5,5,8}; 
        int k = 3; 
        int threshold = 4;

        System.out.println(numOfSubarrays(arr, k, threshold));
    }
}
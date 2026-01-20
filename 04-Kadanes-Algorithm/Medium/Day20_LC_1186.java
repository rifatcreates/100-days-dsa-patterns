import java.util.*;

public class Day20_LC_1186 {
    public static int maximumSum(int arr[]) {
        int noDelete = arr[0];
        int oneDelete = arr[0];
        int res = arr[0];

        for (int i=1; i<arr.length; i++) {
            int prevNoDelete = noDelete;
            int prevOneDelete = oneDelete;

            noDelete = Math.max(noDelete + arr[i], arr[i]);
            oneDelete = Math.max(prevOneDelete + arr[i], prevNoDelete);

            res = Math.max(res, Math.max(noDelete, oneDelete));
        }

        return res;
    }

    public static void main(String args[]) {
        int arr[] = {1,-2,0,3};

        System.out.println(maximumSum(arr));
    }
}
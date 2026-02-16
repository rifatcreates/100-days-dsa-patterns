public class Day46_GFG_Allocate_Minimum_Pages {
    public static boolean helper(int arr[], int k, int guess) {
        int student = 1;
        int pages = 0;

        for (int i=0; i<arr.length; i++) {

            if ((pages + arr[i]) <= guess) {
                pages = pages + arr[i];
            } else {
                student++;
                pages = arr[i];
                if (student > k) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int smallestPossibleMaximum(int arr[], int k) {
        if (arr.length < k) {
            return -1;
        }

        int low = 0;
        int high = 0;
        for (int i=0; i<arr.length; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        int res = -1;

        while (low <= high) {
            int guess = (low+high)/2;

            if (helper(arr, k, guess)) {
                res = guess;
                high = guess-1;
            } else {
                low = guess+1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {12, 34, 67, 90}; 
        int k = 2;

        System.out.println(smallestPossibleMaximum(arr, k));
    }
}
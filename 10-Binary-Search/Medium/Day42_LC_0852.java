public class Day42_LC_0852 {
    public static int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        int res = -1;

        while(low <= high) {
            int guess = (high + low) / 2;

            if (arr[guess] < arr[guess+1]) {
                low = guess+1;
            } else if (arr[guess] > arr[guess+1]) {
                res = guess;
                high = guess-1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 0};

        System.out.println(peakIndexInMountainArray(arr));
    }
}
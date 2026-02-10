public class Day40_GFG_CeilInASortedArray {
    public static int ceil(int arr[], int x) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;

        while (low <= high) {
            int guess = (high + low)/2;

            if (arr[guess] < x) {
                low = guess + 1;
            } else {
                ans = guess;
                high = guess -1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 8, 10, 11, 12, 19}; 
        int x = 5;

        System.out.println(ceil(arr, x));
    }
}
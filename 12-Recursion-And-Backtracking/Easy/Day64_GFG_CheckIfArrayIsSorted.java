public class Day64_GFG_CheckIfArrayIsSorted {
    public static boolean checkRecursive(int[] arr, int index) {
        if (index >= arr.length-1) {
            return true;
        }
        
        if (arr[index] > arr[index+1]) {
            return false;
        }
        
        return checkRecursive(arr, index+1);
    }

    public static boolean isSorted(int arr[]) {
        return checkRecursive(arr, 0);
    }

    public static void main(String args[]) {
        int arr[] = {10, 20, 30, 40, 50};

        System.out.println(isSorted(arr));
    }
}
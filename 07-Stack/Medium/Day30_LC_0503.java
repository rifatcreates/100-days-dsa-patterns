import java.util.*;

public class Day30_LC_0503 {
    public static void printArr(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] nextGreaterElements(int nums[]) {
        int res[] = new int[nums.length];

        Stack<Integer> st = new Stack<>();
        for (int i=nums.length-1; i>=0; i--) {
            st.push(nums[i]);
        }

        for (int i=nums.length-1; i>=0; i--) {

            while(!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }

            st.push(nums[i]);
        }

        return res;
    }

    public static void main(String args[]) {
        int nums[] = {1, 2 ,1};

        int result[] = nextGreaterElements(nums);
        printArr(result);
    }
}
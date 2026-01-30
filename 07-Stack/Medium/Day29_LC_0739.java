import java.util.*;

public class Day29_LC_0739 {
    public static void printArr(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] dailyTemperatures(int temperatures[]) {
        int res[] = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<temperatures.length; i++) {
            
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int prevDay = st.pop();
                res[prevDay] = i - prevDay;
            }

            st.push(i);
        }

        return res;
    }

    public static void main(String args[]) {
        int temperatures[] = {73,74,75,71,69,72,76,73};

        int result[] = dailyTemperatures(temperatures);
        printArr(result);
    }
}
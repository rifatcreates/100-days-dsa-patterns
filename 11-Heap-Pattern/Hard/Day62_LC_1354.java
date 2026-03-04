import java.util.*;

public class Day62_LC_1354 {
    public static boolean isPossible(int target[]) {
        if (target.length == 1) {
            return target[0] == 1;
        }

        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        long totalSum = 0;

        for (int num : target) {
            totalSum += num;
            maxHeap.offer((long) num);
        }

        while (true) {

            long largest = maxHeap.poll();
            long restSum = totalSum - largest;

            if (largest == 1 || restSum == 1) {
                return true;
            }

            if (restSum == 0 || largest < restSum || largest % restSum == 0) {
                return false;
            }

            long previousValue = largest % restSum;

            totalSum = restSum + previousValue;

            maxHeap.offer(previousValue);
        }
    }

    public static void main(String[] args) {
        int target[] = {9, 3, 5};

        System.out.println(isPossible(target));
    }   
}
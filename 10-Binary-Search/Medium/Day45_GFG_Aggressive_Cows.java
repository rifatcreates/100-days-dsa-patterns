import java.util.*;

public class Day45_GFG_Aggressive_Cows {
    public static boolean helper(int stalls[], int k, int guess) {
        int cow = 1;
        int prevPos = stalls[0];

        for (int i=1; i<stalls.length; i++) {
            int dist = stalls[i] - prevPos;

            if (dist < guess) {
                continue;
            }

            prevPos = stalls[i];
            cow++;
        }

        if (cow < k) {
            return false;
        }

        return true;
    }

    public static int minDist(int stalls[], int k) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length-1];
        int res = -1;

        while (low <= high) {
            int guess = (low + high) / 2;

            if (helper(stalls, k, guess)) {
                res = guess;
                low = guess+1;
            } else {
                high = guess-1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int stalls[] = {1, 2, 4, 8, 9}; 
        int k = 3;

        System.out.println(minDist(stalls, k));
    }
}
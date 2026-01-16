import java.util.*;

public class Day16_LC_0202 {
    public static int sumOfSquaresOfDigits(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n%10;
            sum = sum + (digit * digit);
            n = n/10;
        }

        return sum;
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        while (fast != 1) {
            slow = sumOfSquaresOfDigits(slow);
            fast = sumOfSquaresOfDigits(sumOfSquaresOfDigits(fast));

            if (fast == 1) {
                return true;
            }

            if (slow == fast) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        int n = 19;

        System.out.println(isHappy(n));
    }
}
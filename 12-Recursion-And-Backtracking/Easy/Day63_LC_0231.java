public class Day63_LC_0231 {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 2 != 0) {
            return false;
        }

        return isPowerOfTwo(n/2);
    }

    public static void main(String args[]) {
        int n = 16;

        System.out.println(isPowerOfTwo(n));
    }
}
public class Day113_LC_0509_2 {
    public static int fib(int n, int d[]) {
        if (n <= 1) {
            return n;
        }

        if (d[n] != 0) {
            return d[n];
        }

        d[n] = fib(n-1, d) + fib(n-2, d);
        return d[n];
    }

    public static void main(String args[]) {
        int n = 2;
        int d[] = new int[n+1];

        System.out.println(fib(n, d));
    }
}
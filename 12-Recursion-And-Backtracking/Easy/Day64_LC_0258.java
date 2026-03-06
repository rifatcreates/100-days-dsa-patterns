public class Day64_LC_0258 {
    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int currSum = (num % 10) + addDigits(num / 10);

        return addDigits(currSum);
    }

    public static void main(String args[]) {
        int num = 38;

        System.out.println(addDigits(num));
    }
}
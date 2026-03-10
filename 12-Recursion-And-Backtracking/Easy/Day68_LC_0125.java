public class Day68_LC_0125 {
    public static boolean helper(String s, int left, int right) {
        int len = right - left + 1;

        if (len == 0 || len == 1) {
            return true;
        }

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return helper(s, left+1, right-1);
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        return helper(s, 0, s.length()-1);
    }

    public static void main(String args[]) {
        String s = "A man, a plan, a canal: Panama";

        System.out.print(isPalindrome(s));
    }
}
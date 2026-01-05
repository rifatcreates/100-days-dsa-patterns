import java.util.*;

public class Day05_StrobogrammaticNumber {
    public static boolean isStrobogrammatic(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left <= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (leftChar == rightChar) {
                if (leftChar != '0' && leftChar != '1' && leftChar != '8') {
                    return false;
                }
            } else {
                if (!(leftChar == '6' && rightChar == '9') && !(leftChar == '9' && rightChar == '6')) {
                    return false;
                }
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String args[]) {
        String s = "168891";
        System.out.println(isStrobogrammatic(s));
    }
}
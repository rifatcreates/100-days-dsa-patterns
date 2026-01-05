import java.util.*;

public class Day05_ReverseWords {
    public static String reverseWords (String s) {
        String trim = s.trim();
        String str[] = trim.split("\\s+");

        int i = 0;
        int j = str.length - 1;

        while (i < j) {
            String temp = str[i];
            str[i] = str[j];
            str[j] = temp;

            i++;
            j--;
        }

        return String.join(" ", str);
    }

    public static void main(String args[]) {
        String s = "the sky is blue";
        System.out.print(reverseWords(s));
    }
}
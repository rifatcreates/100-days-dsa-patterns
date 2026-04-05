import java.util.*;

public class Day94_LC_0402 {
    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        result.reverse();
        
        String answer = result.toString().replaceFirst("^0+", "");
        
        return answer.isEmpty() ? "0" : answer;
    }

    public static void main(String args[]) {
        String num = "1432219"; 
        int k = 3;

        System.out.println(removeKdigits(num, k));
    }
}
public class Day65_GFG_RemoveAllOccurencesOfACharacter {
    public static void helper(StringBuilder s, char c, int idx) {
        if (idx == s.length()) {
            return;
        }
        
        helper(s, c, idx+1);
        
        if (s.charAt(idx) == c) {
            s.deleteCharAt(idx);
        }
    }

    public static void removeCharacter(StringBuilder s, char c) {
        helper(s, c, 0);
    }

    public static void main(String args[]) {
        StringBuilder s = new StringBuilder("geeksforgeeks");
        char c = 'e';

        removeCharacter(s, c);

        System.out.println(s);
    }
}
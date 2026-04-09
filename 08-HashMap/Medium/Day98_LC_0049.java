import java.util.*;

public class Day98_LC_0049 {
    public static List<List<String>> groupAnagrams(String strs[]) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char ch[] = word.toCharArray();
            Arrays.sort(ch);
            String sortedWord = new String(ch);

            List<String> list = map.getOrDefault(sortedWord, new ArrayList<>());
            list.add(word);
            map.put(sortedWord, list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String args[]) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(strs));
    }
}
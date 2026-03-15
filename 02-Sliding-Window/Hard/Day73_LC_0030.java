import java.util.*;

public class Day73_LC_0030 {
    public static List<Integer> findSubstring(String s, String words[]) {
        List<Integer> result = new ArrayList<>();

        int wordLen = words[0].length();
        int totalWords = words.length;

        Map<String, Integer> wordCount = new HashMap<>();

        for(String w : words){
            wordCount.put(w, wordCount.getOrDefault(w,0)+1);
        }

        for(int i=0;i<wordLen;i++){

            int low = i;
            int high = i;

            int count = 0;

            Map<String,Integer> windowMap = new HashMap<>();

            while(high + wordLen <= s.length()){

                String word = s.substring(high, high + wordLen);
                high += wordLen;

                if(wordCount.containsKey(word)){

                    windowMap.put(word, windowMap.getOrDefault(word,0)+1);
                    count++;

                    while(windowMap.get(word) > wordCount.get(word)){

                        String leftWord = s.substring(low, low + wordLen);

                        windowMap.put(leftWord,
                                windowMap.get(leftWord)-1);

                        low += wordLen;
                        count--;
                    }

                    if(count == totalWords){
                        result.add(low);
                    }

                }
                else{

                    windowMap.clear();
                    count = 0;
                    low = high;
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        String s = "barfoothefoobarman"; 
        String words[] = {"foo", "bar"};

        System.out.println(findSubstring(s, words));
    }
}
package substring.with.concatenation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return ans;
        }
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            if (!wordsMap.containsKey(word)) {
                wordsMap.put(word, 0);
            }
            wordsMap.put(word, wordsMap.get(word) + 1);
        }
        int oneWordSize = words[0].length();
        int allWordSize = words.length * oneWordSize;
        for (int i = 0; i < s.length() - allWordSize + 1; i++) {
            String currentWindow = s.substring(i, i + allWordSize);
            Map<String, Integer> d = new HashMap<>(wordsMap);
            for (int j = 0; j < currentWindow.length(); j += oneWordSize) {
                String key = currentWindow.substring(j, j + oneWordSize);
                if (d.containsKey(key)) {
                    d.put(key, d.get(key) - 1);
                    if (d.get(key) == 0)
                        d.remove(key);
                } else {
                    break;
                }
            }
            if (d.size() == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        Solution solution = new Solution();
        System.out.println(solution.findSubstring(s1, words1));
        System.out.println(solution.findSubstring(s2, words2));
    }
}

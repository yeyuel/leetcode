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

    public List<Integer> findSubstring1(String s, String[] words)
    {
        int left = 0, right = 0, len = 0;
        int size = words.length;
        List<Integer> res = new ArrayList<>();
        if (words.length == 0)
        {
            return res;
        }
        len = words[0].length();
        Map<String, Integer> needs = new HashMap<>();
        Map<String, Integer> windows = new HashMap<>();

        for (int i = 0; i < words.length; i++)
        {
            int count = needs.getOrDefault(words[i], 0);
            needs.put(words[i], count + 1);
        }

        int match = 0;
        for (int i = 0; i < len; i++)
        {
            right = left = i;
            match = 0;
            while (right <= s.length() - len)
            {
                String s1 = s.substring(right, right + len);
                right += len;
                int count = windows.getOrDefault(s1, 0);
                windows.put(s1, count + 1);

                if (needs.containsKey(s1) && windows.get(s1).intValue() == needs
                        .get(s1).intValue())
                {
                    match ++;
                }

                while (left < right && match == needs.size())
                {
                    if ((right - left) / len == size)
                    {
                        res.add(left);
                    }
                    String s2 = s.substring(left, left + len);
                    left += len;
                    windows.put(s2, windows.get(s2) - 1);

                    if (needs.containsKey(s2)
                            && windows.get(s2).intValue() < needs.get(s2)
                            .intValue())
                    {
                        match --;
                    }
                }
            }
            windows.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        Solution solution = new Solution();
        System.out.println(solution.findSubstring1(s1, words1));
        System.out.println(solution.findSubstring1(s2, words2));
    }
}

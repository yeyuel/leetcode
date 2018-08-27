package hash.string.group.anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<List<Integer>, List<String>> anagram = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            List<Integer> code = changeToVector(strs[i]);
            if (!anagram.containsKey(code)) {
                anagram.put(code, new ArrayList<String>());
            }
            anagram.get(code).add(strs[i]);
        }
        for (Map.Entry<List<Integer>, List<String>> entry :
                anagram.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private List<Integer> changeToVector(String str) {
        List<Integer> coder = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            coder.add(0);
        }
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            coder.set(index, coder.get(index) + 1);
        }
        return coder;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));
    }
}

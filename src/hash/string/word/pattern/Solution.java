package hash.string.word.pattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<String, Character> dict = new HashMap<>();
        char[] used = new char[128];
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!dict.containsKey(words[i])) {
                if (used[c] > 0) {
                    return false;
                }
                used[c] = 1;
                dict.put(words[i], c);
            } else {
                if (!Character.valueOf(c).equals(dict.get(words[i]))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String pattern1 = "abba"; String str1 = "dog cat cat dog";
        String pattern2 = "abba"; String str2 = "dog cat cat fish";
        String pattern3 = "aaaa"; String str3 = "dog cat cat dog";
        String pattern4 = "abba"; String str4 = "dog dog dog dog";
        System.out.println(solution.wordPattern(pattern1, str1));
        System.out.println(solution.wordPattern(pattern2, str2));
        System.out.println(solution.wordPattern(pattern3, str3));
        System.out.println(solution.wordPattern(pattern4, str4));
    }
}

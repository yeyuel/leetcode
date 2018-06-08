package longest.substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int start = 0, maxLength = 0;
        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cache.containsKey(c) && start <= cache.get(c)) {
                // last occurrence's next character
                start = cache.get(c) + 1;
            } else {
                maxLength = Math.max(maxLength, i - start + 1);
            }
            cache.put(c, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String test = "dvdf";
        System.out.println(new Solution().lengthOfLongestSubstring(test));
    }
}

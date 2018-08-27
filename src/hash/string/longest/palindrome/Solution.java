package hash.string.longest.palindrome;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        boolean findOdd = false;
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() % 2 > 0) {
                if (!findOdd) {
                    findOdd = true;
                }
                maxCount += entry.getValue() - 1;
            } else if (entry.getValue() % 2 == 0) {
                maxCount += entry.getValue();
            }
        }
        return findOdd ? maxCount + 1 : maxCount;
    }

    public static void main(String[] args) {
        String sample = "abccccdd";
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(sample));
    }
}

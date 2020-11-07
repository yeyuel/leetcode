package longest.substring.least.k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int longestSubstring(String s, int k) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hash[c - 'a'] ++;
        }
        List<Integer> split = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int count = hash[s.charAt(i) - 'a'];
            if (count > 0 && count < k) {
                split.add(i);
            }
        }
        if (split.isEmpty()) {
            return s.length();
        }
        int ans = 0, left = 0;
        split.add(s.length());
        for (int i = 0; i < split.size(); i++) {
            int len = split.get(i) - left;
            if (len > ans) {
                ans = Math.max(ans, longestSubstring(s.substring(left, split.get(i)), k));
            }
            left = split.get(i) + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String input1 = "aaabb";
        String input2 = "ababbc";
        Solution solution = new Solution();
        System.out.println(solution.longestSubstring(input1, 3));
        System.out.println(solution.longestSubstring(input2, 2));
    }
}

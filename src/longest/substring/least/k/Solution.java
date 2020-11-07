package longest.substring.least.k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int longestSubstring1(String s, int k) {
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
                ans = Math.max(ans, longestSubstring1(s.substring(left, split.get(i)), k));
            }
            left = split.get(i) + 1;
        }
        return ans;
    }

    public int longestSubstring2(String s, int k) {
        return cnt(s, 0, s.length() - 1, k);
    }

    private int cnt(String s, int l, int r, int k) {
        int[] chs = new int[26];
        for (int i = l; i <= r; i++) {
            char c = s.charAt(i);
            chs[c - 'a']++;
        }
        int ll = l, rr = r;
        while (ll <= rr && chs[s.charAt(ll) - 'a'] < k) {
            ll++;
        }
        while (ll <= rr && chs[s.charAt(rr) - 'a'] < k) {
            rr--;
        }
        if (rr - ll + 1 < k) {
            return 0;
        }

        int partition = ll;
        while (partition <= rr && chs[s.charAt(partition) - 'a'] >= k) {
            partition++;
        }
        if (partition >= rr) {
            return rr - ll + 1;
        }
        return Math.max(cnt(s, ll, partition - 1, k), cnt(s, partition + 1, rr, k));
    }

    public static void main(String[] args) {
        String input1 = "aaabb";
        String input2 = "ababbc";
        Solution solution = new Solution();
        System.out.println(solution.longestSubstring1(input1, 3));
        System.out.println(solution.longestSubstring1(input2, 2));
        System.out.println(solution.longestSubstring2(input1, 3));
        System.out.println(solution.longestSubstring2(input2, 2));
    }
}

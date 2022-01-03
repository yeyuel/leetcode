package slide.window.anagram.find;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findAnagramsNew(String s, String p) {
        List<Integer> results = new ArrayList<>();
        if (s.length() < p.length()) return results;

        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        int[] need = new int[26];
        for (char value : pArr) {
            need[value - 'a']++;
        }
        int[] window = new int[26];

        int left = 0, right = 0, valid = 0;
        while (right < sArr.length) {
            char c = sArr[right];
            right++;

            if (need[c - 'a'] > 0) {
                window[c - 'a']++;
                if (window[c - 'a'] == need[c - 'a']) valid ++;
            }
            while (right - left >= pArr.length) {
                if (valid == pArr.length) results.add(left);
                char d = sArr[left];
                left ++;
                if (need[d - 'a'] > 0) {
                    if (window[d - 'a'] == need[d - 'a']) valid--;
                    window[d - 'a']--;
                }
            }
        }
        return results;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        if (s.length() < p.length()) {
            return results;
        }

        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        int[] hash = new int[128];

        for (int i = 0; i < pArr.length; i++) {
            hash[pArr[i] - 'a'] ++;
        }

        int l = 0, count = 0, pLength = p.length();
        for (int r = 0; r < sArr.length; r++) {
            hash[sArr[r] - 'a'] --;

            if (hash[sArr[r] - 'a'] >= 0) {
                count++;
            }

            while (r - l + 1 > pLength) {
                hash[sArr[l] - 'a'] ++;

                if (hash[sArr[l] - 'a'] > 0) {
                    count--;
                }

                l++;
            }

            if (count == pLength) {
                results.add(l);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> anagrams = solution.findAnagramsNew("sdfsdiifsdfjsjdhfsdf", "sdf");
        System.out.println(anagrams.toString());
    }
}

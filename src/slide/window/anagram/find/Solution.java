package slide.window.anagram.find;

import java.util.ArrayList;
import java.util.List;

public class Solution {

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

            if (r > pLength - 1) {
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
        List<Integer> anagrams = solution.findAnagrams("sdfsdiifsdfjsjdhfsdf", "sdi");
        System.out.println(anagrams.toString());
    }
}

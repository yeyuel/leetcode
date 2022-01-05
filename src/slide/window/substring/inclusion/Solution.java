package slide.window.substring.inclusion;


public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        int[] hash = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            hash[s1Arr[i] - 'a'] ++;
        }
        int l = 0, count = 0;
        for (int r = 0; r < s2Arr.length; r++) {
            hash[s2Arr[r] - 'a'] --;

            if (hash[s2Arr[r] - 'a'] >= 0) {
                count++;
            }

            while (r - l + 1 > s1Arr.length) {
                hash[s2Arr[l] - 'a']++;
                if (hash[s2Arr[l] - 'a'] >= 1) {
                    count --;
                }
                l++;
            }
            if (count == s1.length()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkInclusionNew(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        int[] need = new int[26];
        int[] window = new int[26];

        for (char c : s1Arr) {
            need[c - 'a']++;
        }

        int l = 0, r = 0, valid = 0;
        while (r < s2Arr.length) {
            char c = s2Arr[r];
            r ++;

            if (++window[c - 'a'] == need[c - 'a']) valid++;

            while (r - l > s1Arr.length) {
                char d = s2Arr[l];
                l++;
                if (window[d - 'a'] > 0){
                    if (--window[d - 'a'] < need[d - 'a']) valid--;
                }
            }
            if (valid == s1Arr.length) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "bd";
        String s2 = "eidbaooo";
        Solution solution = new Solution();
        System.out.println(solution.checkInclusionNew(s1, s2));
    }
}

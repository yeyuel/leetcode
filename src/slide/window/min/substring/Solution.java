package slide.window.min.substring;

public class Solution {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int[] hash = new int[256];

        for (int i = 0; i < t.length(); i++) {
            hash[tArr[i]]++;
        }

        int l = 0, count = tArr.length, max = s.length() + 1;
        String result = "";
        for (int r = 0; r < sArr.length; r++) {
            hash[sArr[r]] --;

            if (hash[sArr[r]] >= 0) {
                count--;
            }

            while (l < r && hash[sArr[l]] < 0) {
                hash[sArr[l]] ++;
                l++;
            }

            if (count == 0 && max > r - l + 1) {
                max = r - l + 1;
                result = s.substring(l, r + 1);
            }
        }
        return result;
    }

    private String minWindowNew(String s, String t) {
        if (s.length() < t.length()) return "";

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int[] window = new int[26];
        int[] need = new int[26];

        int targetValid = 0;
        for (char c : tArr) {
            if (++need[c - 'A'] == 1) targetValid++;
        }

        int l = 0, r = 0, valid = 0, max = sArr.length + 1;
        String result = "";
        while (r < sArr.length) {
            char c = sArr[r];
            r++;

            if (++window[c - 'A'] == need[c - 'A']) valid++;

            while (valid == targetValid) {
                if (r - l < max) {
                    max = r - l;
                    result = s.substring(l, r);
                }
                char d = sArr[l];
                l++;

                if (--window[d - 'A'] < need[d - 'A']) valid--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        Solution solution = new Solution();
//        System.out.println(solution.minWindow(s, t));
        System.out.println(solution.minWindowNew(s, t));
    }
}

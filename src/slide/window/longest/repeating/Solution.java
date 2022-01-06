package slide.window.longest.repeating;

public class Solution {

    private int characterReplacementNew(String s, int k) {
        if (s == null || s.length() == 0) return 0;

        char[] sArr = s.toCharArray();
        int[] hash = new int[26];

        int l = 0, r = 0, max = 0, result = 0;
        while (r < sArr.length) {
            char c = sArr[r];
            r++;

            max = Math.max(++hash[c - 'A'], max);

            while (r - l > k + max) {
                char d = sArr[l];
                l++;
                hash[d - 'A']--;
            }
            result = Math.max(r - l, result);
        }
        return result;
    }

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] sArr = s.toCharArray();
        int[] hash = new int[26];

        int l = 0, maxCount = 0, result = 0;
        for (int r = 0; r < sArr.length; r++) {
            hash[sArr[r] - 'A']++;

            maxCount = Math.max(maxCount, hash[sArr[r] - 'A']);

            while (r - l + 1 - maxCount > k) {
                hash[sArr[l] - 'A'] --;
                l ++;
            }
            result = Math.max(r - l + 1, result);
        }
        return  result;
    }

    public static void main(String[] args) {
        String input = "AABABBA";
        int k = 1;
        System.out.println(new Solution().characterReplacement(input, k));
        System.out.println(new Solution().characterReplacementNew(input, k));
    }
}

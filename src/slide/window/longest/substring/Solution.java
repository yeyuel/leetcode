package slide.window.longest.substring;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] sArr = s.toCharArray();
        int[] hash = new int[256];

        int l = 0, result = 1;

        for (int r = 0; r < sArr.length; r++) {
            hash[sArr[r]]++;

            while (hash[sArr[r]] > 1) {
                hash[sArr[l]]--;
                l ++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}

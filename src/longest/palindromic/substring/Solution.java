package longest.palindromic.substring;

public class Solution {

    /**
     * Dynamic Programming Solution
     * @param s
     * @return longest palindromic substring
     */
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L --;
            R ++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "babad";
        String str2 = "cbbd";
        System.out.println(solution.longestPalindrome(str1));
        System.out.println(solution.longestPalindrome(str2));
    }
}

package implement.str;

/**
 * 28
 */
public class Solution {

    class KMP {
        private int[][] dp;
        private String pattern;

        public KMP(String pattern) {
            this.pattern = pattern;
            int M = pattern.length();
            dp = new int[M][256];
            dp[0][pattern.charAt(0)] = 1;
            int X = 0;
            for (int i = 0; i < M; i++) {
                for (int c = 0; c < 256; c++) {
                    if (pattern.charAt(i) == c) {
                        dp[i][c] = i + 1;
                    } else {
                        dp[i][c] = X;
                    }
                }
                X = dp[X][pattern.charAt(i)];
            }
        }

        public int search(String text) {
            int M = pattern.length();
            int N = text.length();
            int j = 0;
            for (int i = 0; i < N; i++) {
                j = dp[j][text.charAt(i)];
                if (j == M) return i - M + 1;
            }
            return -1;
        }
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }

    public static void main(String[] args) {
        String haystack1 = "hello", needle1 = "ll";
        String haystack2 = "aaaa", needle2 = "bba";
        Solution solution = new Solution();
        System.out.println(solution.strStr(haystack1, needle1));
        System.out.println(solution.strStr(haystack2, needle2));
    }
}

package implement.str;

/**
 * 28
 */
public class Solution {

    class KMP {
        private int[][] dp;
        private int M;

        public KMP(String pattern) {
            M = pattern.length();
            dp = new int[M][256];
            int X = 0;
            dp[0][pattern.charAt(0)] = 1;
            for (int i = 1; i < M; i++) {
                for (int c = 0; c < 256; c++) {
                    dp[i][c] = dp[X][c];
                }
                dp[i][pattern.charAt(i)] = i + 1;
                X = dp[X][pattern.charAt(i)];
            }
        }

        public int search(String text) {
            int N = text.length();
            int j = 0;
            for (int i = 0; i < N; i++) {
                j = dp[j][text.charAt(i)];
                if (j == M) return i - M + 1;
            }
            return -1;
        }
    }

    public int strStr1(String haystack, String needle) {
        if(needle.equals("")) {
            return 0;
        }
        if(haystack.equals("")) {
            return -1;
        }
        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }

    public int strStr(String haystack, String needle) {
        if(needle.equals("")) {
            return 0;
        }
        if(haystack.equals("")) {
            return -1;
        }

        // 构造KMP中的dp矩阵
        int m = needle.length();
        // 各个状态(行)遇到下一个字符(列)跳转到哪个状态
        int[][] dp = new int[m][256];
        // 影子状态
        int X = 0;
        dp[0][needle.charAt(0)] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 256; j++) {
                //假设下个字符不匹配，此时要回去看影子状态，从而得知跳转到哪个状态
                dp[i][j] = dp[X][j];
            }
            // 只有pat上i的字符匹配，跳转到下个状态
            dp[i][needle.charAt(i)] = i + 1;
            // 更新影子状态
            X = dp[X][needle.charAt(i)];
        }

        // 构造dp完成后，开始search
        // 初始状态为0
        int s = 0;
        for (int i = 0; i < haystack.length(); i++) {
            s = dp[s][haystack.charAt(i)];
            if (s == m) {
                return i - m + 1;
            }
        }

        // 匹配失败，返回-1
        return -1;
    }

    public static void main(String[] args) {
        String haystack1 = "hello", needle1 = "ll";
        String haystack2 = "aaaa", needle2 = "bba";
        String haystack3 = "mississippi", needle3 = "issipi";
        Solution solution = new Solution();
        System.out.println(solution.strStr1(haystack1, needle1));
        System.out.println(solution.strStr1(haystack2, needle2));
        System.out.println(solution.strStr1(haystack3, needle3));
    }
}

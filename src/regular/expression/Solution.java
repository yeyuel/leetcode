package regular.expression;

public class Solution
{

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean firstMatch = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) || // pattern before * could be zero times
                    (firstMatch && isMatch(text.substring(1), pattern)));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    enum Result
    {
        TRUE, FALSE;
    }

    public boolean isMatch1(String text, String pattern)
    {
        Result[][] memo = new Result[text.length() + 1][pattern.length() + 1];

        return dp(0, 0, text, pattern, memo);
    }

    private boolean dp(int i, int j, String text, String pattern, Result[][] memo)
    {
        if (memo[i][j] != null)
        {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length())
        {
            ans = i == text.length();
        }
        else
        {
            boolean firstMatch = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i)
                            || pattern.charAt(j) == '.'));
            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*')
            {
                ans = (dp(i, j + 2, text, pattern, memo) ||
                        firstMatch && dp(i + 1, j, text, pattern, memo));
            }
            else
            {
                ans = firstMatch && dp(i + 1, j + 1, text, pattern, memo);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    public boolean isMatch2(String text, String pattern)
    {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;
        for (int i = text.length(); i >= 0; i--)
        {
            for (int j = pattern.length() - 1; j >= 0; j--)
            {
                boolean firstMatch = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*')
                {
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                }
                else
                {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String s1 = "aa"; String p1 = "a";
        String s2 = "aa"; String p2 = "a*";
        String s3 = "ab"; String p3 = ".*";
        String s4 = "aab"; String p4 = "c*a*b";
        String s5 = "mississippi"; String p5 = "mis*is*p*.";
        String s6 = "bbb"; String p6 = "a*b*";
        Solution solution = new Solution();
        System.out.println(solution.isMatch2(s1, p1));
        System.out.println(solution.isMatch2(s2, p2));
        System.out.println(solution.isMatch2(s3, p3));
        System.out.println(solution.isMatch2(s4, p4));
        System.out.println(solution.isMatch2(s5, p5));
        System.out.println(solution.isMatch2(s6, p6));
    }
}

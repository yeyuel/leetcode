/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package dynamic.programming.longest.valid.parentheses;

import javax.security.auth.callback.CallbackHandler;
import java.util.Stack;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/7/10$
 * @since 1.0
 */
public class Solution
{
    public int longestValidParentheses(String s)
    {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i + 2; j <= s.length(); j++)
            {
                if (isValid(s.substring(i, j)))
                {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    public int longestValidParentheses2(String s)
    {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++)
        {
            if (s.charAt(i) == ')')
            {
                if (s.charAt(i - 1) == '(')
                {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                else if (i - dp[i - 1] > 0
                        && s.charAt(i - dp[i - 1] - 1) == '(')
                {
                    dp[i] = dp[i - 1] + (
                            (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0)
                                    + 2);
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    private boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                stack.push('(');
            }
            else if (!stack.empty() && stack.peek() == '(')
            {
                stack.pop();
            }
            else
            {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args)
    {
        String s1 = "(()";
        String s2 = ")()())";

        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(s1));
        System.out.println(solution.longestValidParentheses(s2));
        System.out.println(solution.longestValidParentheses2(s1));
        System.out.println(solution.longestValidParentheses2(s2));
    }
}

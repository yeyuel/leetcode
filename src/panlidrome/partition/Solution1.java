/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package panlidrome.partition;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * Solution1.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/11/18$
 * @since 1.0
 */
public class Solution1
{
    public List<List<String>> partition(String s)
    {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0)
        {
            return res;
        }
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++)
        {
            for (int left = 0; left <= right; left++)
            {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2
                        || dp[left + 1][right - 1]))
                {
                    dp[left][right] = true;
                }
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, dp, stack, res);
        return res;
    }

    private void backtracking(String s, int start, int len, boolean[][] dp,
            Deque<String> path, List<List<String>> res)
    {
        if (start == len)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++)
        {
            if (!dp[start][i])
            {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, dp, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args)
    {
        String input = "aab";
        System.out.println((new Solution1().partition(input)));
    }
}

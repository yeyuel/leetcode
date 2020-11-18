/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package panlidrome.partition;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/11/18$
 * @since 1.0
 */
public class Solution
{
    public List<List<String>> partition(String s)
    {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0)
        {
            return res;
        }
        recur(s, 0, len, res, new ArrayDeque<>());
        return res;
    }

    private void recur(String s, int start, int len, List<List<String>> ret,
            Deque<String> current)
    {
        if (start == len)
        {
            ret.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < len; i++)
        {
            if (!isPanlidrome(s, start, i))
            {
                continue;
            }
            current.addLast(s.substring(start, i + 1));
            recur(s, i + 1, len, ret, current);
            current.removeLast();
        }
    }

    private boolean isPanlidrome(String s, int left, int right)
    {
        boolean ans = true;
        while (left < right)
        {
            if (s.charAt(left) != s.charAt(right))
            {
                ans = false;
                break;
            }
            left ++;
            right--;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        String input = "aab";
        System.out.println((new Solution().partition(input)));
    }
}

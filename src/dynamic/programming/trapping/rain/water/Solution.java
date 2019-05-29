/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package dynamic.programming.trapping.rain.water;

import java.util.Stack;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/5/29$
 * @since 1.0
 */
public class Solution
{

    public int trap1(int[] height)
    {
        if (height == null || height.length < 3)
        {
            return 0;
        }
        int[] dp = new int[height.length];
        int count = 0;
        int mx = 0;
        for (int i = 1; i < height.length; i++)
        {
            dp[i] = mx;
            mx = Math.max(mx, height[i]);
        }
        mx = 0;
        for (int i = height.length - 1; i >= 0; i--)
        {
            dp[i] = Math.min(dp[i], mx);
            mx = Math.max(mx, height[i]);
            if (dp[i] > height[i])
            {
                count += dp[i] - height[i];
            }
        }
        return count;
    }

    public int trap2(int[] height)
    {
        int count = 0, l = 0, r = height.length - 1;
        while (l < r)
        {
            int mn = Math.min(height[l], height[r]);
            if (height[l] == mn)
            {
                ++l;
                while (l < r && height[l] < mn)
                {
                    count += mn - height[l++];
                }
            }
            else
            {
                --r;
                while (l < r && height[r] < mn)
                {
                    count += mn - height[r--];
                }
            }
        }
        return count;
    }

    public int trap3(int[] height)
    {
        int l = 0, r = height.length - 1, level = 0, count = 0;
        while (l < r)
        {
            int lower = height[height[l] < height[r] ? l++ : r--];
            level = Math.max(level, lower);
            count += level - lower;
        }
        return count;
    }

    public int trap4(int[] height)
    {
        Stack<Integer> s = new Stack<>();
        int i = 0, n = height.length, res = 0;
        while (i < n) {
            if (s.isEmpty() || height[i] <= height[s.peek()]) {
                s.push(i++);
            } else {
                int t = s.pop();
                if (s.isEmpty()) continue;
                res += (Math.min(height[i], height[s.peek()]) - height[t]) * (i
                        - s.peek() - 1);
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] sample = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        Solution solution = new Solution();
        System.out.println(solution.trap1(sample));
        System.out.println(solution.trap2(sample));
        System.out.println(solution.trap3(sample));
        System.out.println(solution.trap4(sample));
    }
}

/*
 * Copyright (c) 2021 NeuLion, Inc. All Rights Reserved.
 */
package joseph.circle;

/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2021/4/6$
 * @since 1.0
 */
public class Solution
{
    public int joseph(int n, int m)
    {
        if (n <= 1 || m <= 1) return -1;

        if (n == 2)
        {
            if (m % 2 == 0) return 1;
            else return 2;
        }
        else
        {
            return (joseph(n - 1, m) + m - 1) % n + 1;
        }
    }

    public int joseph(int n, int m, int k)
    {
        if (k == 1)
        {
            return (n + m - 1) % n;
        }
        else
        {
            return ((joseph(n - 1, m, k - 1) + m) % n);
        }
    }

    public int joseph1(int n, int m)
    {
        return joseph(n, m, n) + 1;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.joseph(5, 3));
        System.out.println(solution.joseph1(5, 3));

    }
}

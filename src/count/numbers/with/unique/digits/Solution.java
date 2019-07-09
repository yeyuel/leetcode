/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package count.numbers.with.unique.digits;

/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/7/9$
 * @since 1.0
 */
public class Solution
{
    public int countNumbersWithUniqueDigits(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        int res = 10, count = 9;
        for (int i = 2; i <= n; i++)
        {
            count *= (11 - i);
            res += count;
        }
        return res;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.
                countNumbersWithUniqueDigits(2));
    }
}

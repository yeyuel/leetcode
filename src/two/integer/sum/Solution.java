/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package two.integer.sum;

/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/9/29$
 * @since 1.0
 */
public class Solution
{
    public int getSum(int a, int b)
    {
        while (b != 0)
        {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.getSum(1, 2));
        System.out.println(solution.getSum(-2, 3));
    }
}

/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package product.except.self;

import java.util.Arrays;


/**
 * Solution. 238
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/15$
 * @since 1.0
 */
public class Solution
{
    public int[] productExceptSelf1(int[] nums)
    {
        int length = nums.length;

        int[] L = new int[length];
        int[] R = new int[length];
        int[] ans = new int[length];

        L[0] = 1;
        for (int i = 1; i < length; i++)
        {
            L[i] = nums[i - 1] * L[i - 1];
        }
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i --)
        {
            R[i] = nums[i + 1] * R[i + 1];
        }
        for (int i = 0; i < length; i++)
        {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }

    public int[] productExceptSelf2(int[] nums)
    {
        int length = nums.length;
        int[] ans = new int[length];

        ans[0] = 1;
        for (int i = 1; i < length; i++)
        {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = length - 1; i >= 0; i--)
        {
            ans[i] = ans[i] * R;
            R *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] input = new int[] { 1, 2, 3, 4 };
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf1(input)));
        System.out.println(Arrays.toString(solution.productExceptSelf2(input)));
    }
}

/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package mulitiply.max.sub.array;

/**
 * Solution. 152
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/9/29$
 * @since 1.0
 */
public class Solution
{
    public int maxProduct(int[] nums)
    {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        maxF[0] = nums[0];
        minF[0] = nums[0];
        for (int i = 1; i < length; i++)
        {
            maxF[i] = Math.max(maxF[i - 1] * nums[i],
                    Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i],
                    Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; i++)
        {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] input1 = { 2, 3, -2, 4 };
        int[] input2 = { -2, 0, -1 };
        int[] input3 = { 0, 2 };
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(input1));
        System.out.println(solution.maxProduct(input2));
        System.out.println(solution.maxProduct(input3));
    }
}

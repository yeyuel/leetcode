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
        int maxF = nums[0];
        int minF = nums[0];
        int ans = nums[0];
        for (int i = 1; i < length; i++)
        {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i],
                    Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i],
                    Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
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

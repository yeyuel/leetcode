/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package missing.number;

/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/11/16$
 * @since 1.0
 */
public class Solution
{
    public int missingNumber(int[] nums)
    {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++)
        {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] input1 = new int[] { 3, 0, 1 };
        int[] input2 = new int[] { 0, 1 };
        int[] input3 = new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        int[] input4 = new int[] { 0 };
        System.out.println(solution.missingNumber(input1));
        System.out.println(solution.missingNumber(input2));
        System.out.println(solution.missingNumber(input3));
        System.out.println(solution.missingNumber(input4));
    }
}

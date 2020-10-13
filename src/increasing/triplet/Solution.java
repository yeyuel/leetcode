/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package increasing.triplet;

/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/13$
 * @since 1.0
 */
public class Solution
{
    public boolean increasingTriplet(int[] nums)
    {
        if (nums.length < 3)
            return false;
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums)
        {
            if (num <= small)
            {
                small = num;
            }
            else if (num <= mid)
            {
                mid = num;
            }
            else if (num > mid)
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] input1 = new int[] { 1, 2, 3, 4, 5 };
        int[] input2 = new int[] { 5, 4, 3, 2, 1 };
        int[] input3 = new int[] { 2, 1, 5, 0, 4, 6 };
        int[] input4 = new int[] { 5, 1, 5, 5, 2, 5, 4 };
        int[] input5 = new int[] { 2, 1, 5, 0, 3 };

        Solution solution = new Solution();
        System.out.println(solution.increasingTriplet(input1));
        System.out.println(solution.increasingTriplet(input2));
        System.out.println(solution.increasingTriplet(input3));
        System.out.println(solution.increasingTriplet(input4));
        System.out.println(solution.increasingTriplet(input5));
    }
}

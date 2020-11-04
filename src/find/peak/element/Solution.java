/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package find.peak.element;

/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/11/3$
 * @since 1.0
 */
public class Solution
{
    public int findPeakElement(int[] nums)
    {
        int l = 0, r = nums.length - 1;
        while (l < r)
        {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
            {
                r = mid;
            }
            else
            {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] input1 = new int[] { 1, 2, 3, 1 };
        int[] input2 = new int[] { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println(solution.findPeakElement(input1));
        System.out.println(solution.findPeakElement(input2));
    }
}

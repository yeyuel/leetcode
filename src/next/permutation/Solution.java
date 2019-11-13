/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package next.permutation;

import java.util.Arrays;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/11/13$
 * @since 1.0
 */
public class Solution
{
    public void nextPermutation(int[] nums)
    {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i])
        {
            i --;
        }
        if (i >= 0)
        {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i])
            {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start)
    {
        int i = start, j = nums.length - 1;
        while (i < j)
        {
            swap(nums, i, j);
            i ++;
            j --;
        }
    }


    public static void main(String[] args)
    {
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 3, 2, 1 };
        int[] nums3 = { 1, 1, 5 };
        Solution solution = new Solution();
        solution.nextPermutation(nums1);
        solution.nextPermutation(nums2);
        solution.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }
}

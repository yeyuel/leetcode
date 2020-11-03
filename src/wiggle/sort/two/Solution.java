/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package wiggle.sort.two;

import java.util.Arrays;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/30$
 * @since 1.0
 */
public class Solution
{
    public void wiggleSort1(int[] nums)
    {
        int size = nums.length;
        Arrays.sort(nums);
        int[] tmp = Arrays.copyOfRange(nums, 0, nums.length);
        int k = size - 1;
        for (int i = 1; i < size; i+=2)
        {
            nums[i] = tmp[k--];
        }
        for (int i = 0; i < size; i+=2)
        {
            nums[i] = tmp[k--];
        }
    }

    public void wiggleSort2(int[] nums)
    {
        int midIndex = quickSelect(nums, 0, nums.length - 1);
        int mid = nums[midIndex];
        int n = nums.length;
        for (int i = 0, j = 0, k = nums.length - 1; j <= k; ) // three way partition
        {
            if (nums[V(j, n)] > mid)
            {
                swap(nums, V(j++, n), V(i++, n));
            }
            else if (nums[V(j, n)] < mid)
            {
                swap(nums, V(j, n), V(k--, n));
            }
            else
            {
                j++;
            }
        }
    }

    public int V(int i, int n)
    {
        return (1 + 2 * (i)) % (n | 1);
    }

    private int quickSelect(int[] nums, int left, int right)
    {
        int pivot = nums[left];
        int l = left, r = right;
        while (l < r)
        {
            while (l < r && nums[r] >= pivot)
            {
                r --;
            }
            if (l < r)
            {
                nums[l++] = nums[r];
            }
            while (l < r && nums[l] < pivot)
            {
                l++;
            }
            if (l < r)
            {
                nums[r--] = nums[l];
            }
            nums[l] = pivot;
        }
        if (l == nums.length / 2)
        {
            return l;
        }
        else if (l > nums.length / 2)
        {
            return quickSelect(nums, left, l - 1);
        }
        else
        {
            return quickSelect(nums, l + 1, right);
        }
    }

    private void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args)
    {
        int[] input1 = new int[] { 1, 5, 1, 1, 6, 4 };
        int[] input2 = new int[] { 1, 3, 2, 2, 3, 1 };
        Solution solution = new Solution();
        solution.wiggleSort1(input1);
        solution.wiggleSort1(input2);
        System.out.println(Arrays.toString(input1));
        System.out.println(Arrays.toString(input2));

        input1 = new int[] { 1, 5, 1, 1, 6, 4 };
        input2 = new int[] { 1, 3, 2, 2, 3, 1 };
        solution.wiggleSort2(input1);
        solution.wiggleSort2(input2);
        System.out.println(Arrays.toString(input1));
        System.out.println(Arrays.toString(input2));
    }
}

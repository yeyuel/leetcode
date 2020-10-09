/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package majority.element;

import java.util.Random;


/**
 * Solution. 169
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/9$
 * @since 1.0
 */
public class Solution
{
    /*
        random method
     */
    private int randRange(Random rand, int min, int max)
    {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num)
    {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == num)
            {
                count++;
            }
        }
        return count;
    }

    public int majorityElement1(int[] nums)
    {
        Random rand = new Random();
        int majorityCount = nums.length / 2;
        while (true)
        {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount)
            {
                return candidate;
            }
        }
    }

    /*
        divide and conquer method
     */
    private int countInRange(int[] nums, int num, int lo, int hi)
    {
        int count = 0;
        for (int i = lo; i <= hi; i ++)
        {
            if (nums[i] == num)
            {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi)
    {
        if (lo == hi)
        {
            return nums[lo];
        }
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);
        if (left == right)
        {
            return left;
        }
        int leftCount = countInRange(nums, left, lo, right);
        int rightCount = countInRange(nums, right, lo, right);
        return leftCount > rightCount ? left : right;
    }

    public int majorityElement2(int[] nums)
    {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    /*
    vote method
     */
    public int majorityElement3(int[] nums)
    {
        int count = 0;
        Integer candidate = null;
        for (int num : nums)
        {
            if (count == 0)
            {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }


    public static void main(String[] args)
    {
        int[] input1 = new int[] { 3, 2, 3 };
        int[] input2 = new int[] { 2, 2, 1, 1, 1, 2, 2 };
        Solution solution = new Solution();
        System.out.println(solution.majorityElement1(input1));
        System.out.println(solution.majorityElement1(input2));
        System.out.println(solution.majorityElement2(input1));
        System.out.println(solution.majorityElement2(input2));
        System.out.println(solution.majorityElement3(input1));
        System.out.println(solution.majorityElement3(input2));
    }
}

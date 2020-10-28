/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package max.sliding.window;

import java.util.*;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/28$
 * @since 1.0
 */
public class Solution
{
    Deque<Integer> deq = new ArrayDeque<>();
    int[] nums;

    public void cleanDeque(int i, int k)
    {
        if (!deq.isEmpty() && deq.getFirst() == i - k)
        {
            deq.removeFirst();
        }
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
            deq.removeLast();
    }

    public int[] maxSlidingWindow1(int[] nums, int k)
    {
        int n = nums.length;
        if (n * k == 0)
            return new int[0];
        if (k == 1) return nums;
        this.nums = nums;
        int maxIdx = 0;
        for (int i = 0; i < k; i++)
        {
            cleanDeque(i, k);
            deq.addLast(i);
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        }
        int[] output = new int[n - k + 1];
        output[0] = nums[maxIdx];

        for (int i = k; i < n; i++)
        {
            cleanDeque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

    public int[] maxSlidingWindow2(int[] nums, int k)
    {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++)
        {
            if (i % k == 0)
            {
                left[i] = nums[i];
            }
            else
            {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
            int j = n - i - 1;
            if ((j + 1) % k == 0)
            {
                right[j] = nums[j];
            }
            else
            {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }
        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
        {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }
        return output;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow1(nums, k)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow2(nums, k)));
    }
}

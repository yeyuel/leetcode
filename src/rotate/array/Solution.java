/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package rotate.array;

import java.util.Arrays;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/10$
 * @since 1.0
 */
public class Solution
{
    public void rotate1(int[] nums, int k)
    {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++)
        {
            int current = start;
            int prev = nums[start];
            do
            {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            }
            while (start != current);
        }
    }

    public void rotate2(int[] nums, int k)
    {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end)
    {
        while (start < end)
        {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args)
    {
        int[] input1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int[] input2 = new int[] { -1, -100, 3, 99 };
        Solution solution = new Solution();
        solution.rotate1(input1, 3);
        solution.rotate1(input2, 2);
        System.out.println(Arrays.toString(input1));
        System.out.println(Arrays.toString(input2));

        input1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        input2 = new int[] { -1, -100, 3, 99 };
        solution.rotate2(input1, 3);
        solution.rotate2(input2, 2);
        System.out.println(Arrays.toString(input1));
        System.out.println(Arrays.toString(input2));
    }
}

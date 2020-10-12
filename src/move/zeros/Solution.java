/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package move.zeros;

import java.util.Arrays;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/12$
 * @since 1.0
 */
public class Solution
{
    public void moveZeroes1(int[] nums)
    {
        int lastNoneZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != 0)
            {
                nums[lastNoneZeroFoundAt++] = nums[i];
            }
        }
        for (int i = lastNoneZeroFoundAt; i < nums.length; i ++)
        {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums)
    {
        for (int lastNoneZeorFoundAt = 0, cur = 0; cur < nums.length; cur++)
        {
            if (nums[cur] != 0)
            {
                int tmp = nums[cur];
                nums[lastNoneZeorFoundAt] = nums[cur];
                nums[cur] = tmp;
                lastNoneZeorFoundAt++;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] input1 = new int[] { 0, 1, 0, 3, 12 };
        new Solution().moveZeroes1(input1);
        System.out.println(Arrays.toString(input1));
        input1 = new int[] { 0, 1, 0, 3, 12 };
        new Solution().moveZeroes2(input1);
        System.out.println(Arrays.toString(input1));
    }
}

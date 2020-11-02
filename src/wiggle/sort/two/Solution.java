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
    public void wiggleSort(int[] nums)
    {
        
    }

    public static void main(String[] args)
    {
        int[] input1 = new int[] { 1, 5, 1, 1, 6, 4 };
        int[] input2 = new int[] { 1, 3, 2, 2, 3, 1 };
        Solution solution = new Solution();
        solution.wiggleSort(input1);
        System.out.println(Arrays.toString(input1));
        solution.wiggleSort(input2);
        System.out.println(Arrays.toString(input2));
    }
}

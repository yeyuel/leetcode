/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package contain.duplicate;

import java.util.HashSet;
import java.util.Set;


/**
 * Solution. 217
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/12$
 * @since 1.0
 */
public class Solution
{
    public boolean containsDuplicate(int[] nums)
    {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums)
        {
            if (!set.add(num))
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] input1 = new int[] { 1, 2, 3, 1 };
        int[] input2 = new int[] { 1, 2, 3, 4 };
        int[] input3 = new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };

        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(input1));
        System.out.println(solution.containsDuplicate(input2));
        System.out.println(solution.containsDuplicate(input3));
    }
}

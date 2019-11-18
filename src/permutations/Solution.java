/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package permutations;

import sun.plugin.WJcovUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/11/18$
 * @since 1.0
 */
public class Solution
{
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> ret = new ArrayList<>();
        permute(nums, 0, new ArrayList<>(), ret, new HashSet<>());
        return ret;
    }

    private void permute(int[] nums, int level,
            List<Integer> current, List<List<Integer>> ret,
            Set<Integer> choices)
    {

        if (level == nums.length)
        {
            List<Integer> record = new ArrayList<>(current);
            ret.add(record);
            return;
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (choices.add(nums[i]))
            {
                current.add(nums[i]);
                permute(nums, current.size(), current, ret, choices);
                current.remove(current.size() - 1);
                choices.remove(nums[i]);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] input = { 1, 2, 3 };
        System.out.println(new Solution().permute(input));
    }
}

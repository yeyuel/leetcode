/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package permutations.unique;

import java.util.*;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/11/19$
 * @since 1.0
 */
public class Solution
{
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        Arrays.sort(nums);
        List<Integer> numList = new ArrayList<>();
        for (int num : nums)
        {
            numList.add(num);
        }
        Set<List<Integer>> ret = new HashSet<>();
        permuteUnique(numList, 0, ret);
        return new ArrayList<>(ret);
    }

    private void permuteUnique(List<Integer> nums, int start, Set<List<Integer>> ret)
    {
        if (start == nums.size())
        {
            ret.add(new ArrayList<>(nums));
        }
        for (int i = start; i < nums.size(); i++)
        {
            Collections.swap(nums, start, i);
            permuteUnique(nums, start + 1, ret);
            Collections.swap(nums, start, i );
        }
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 1, 2 };
        System.out.println(new Solution().permuteUnique(nums));
    }
}

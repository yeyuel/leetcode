/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package two.array.intersect;

import java.util.*;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/13$
 * @since 1.0
 */
public class Solution
{
    public int[] intersect1(int[] nums1, int[] nums2)
    {
        Map<Integer, Integer> counter = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int num : nums1)
        {
            if (!counter.containsKey(num))
            {
                counter.put(num, 0);
            }
            counter.put(num, counter.get(num) + 1);
        }
        for (int num : nums2)
        {
            if (counter.containsKey(num) && counter.get(num) > 0)
            {
                ans.add(num);
                counter.put(num, counter.get(num) - 1);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersect2(int[] nums1, int[] nums2)
    {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2)
        {
            if (nums1[index1] < nums2[index2])
            {
                index1 ++;
            }
            else if (nums1[index1] > nums2[index2])
            {
                index2++;
            }
            else
            {
                intersection[index] = nums1[index1];
                index1++; index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[] args)
    {
        int[] nums1 = new int[] { 1, 2, 2, 1 };
        int[] nums2 = new int[] { 2, 2, };

        int[] nums3 = new int[] { 4, 9, 5 };
        int[] nums4 = new int[] { 9, 4, 9, 8, 4 };

        Solution solution = new Solution();
        final int[] intersect1 = solution.intersect1(nums1, nums2);
        final int[] intersect2 = solution.intersect1(nums3, nums4);

        System.out.println(Arrays.toString(intersect1));
        System.out.println(Arrays.toString(intersect2));
    }
}

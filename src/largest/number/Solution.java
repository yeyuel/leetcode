/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package largest.number;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/30$
 * @since 1.0
 */
public class Solution
{
    private class LargerNumberComparator implements Comparator<String>
    {
        @Override
        public int compare(String a, String b)
        {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums)
    {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, new LargerNumberComparator());

        if (asStrs[0].equals("0"))
        {
            return "0";
        }
        String largestNumberStr = new String();
        for (String asStr : asStrs)
        {
            largestNumberStr += asStr;
        }
        return largestNumberStr;
    }

    public static void main(String[] args)
    {
        int[] nums1 = new int[] { 10, 2 };
        int[] nums2 = new int[] { 3, 30, 34, 5, 9 };
        int[] nums3 = new int[] { 1 };
        int[] nums4 = new int[] { 10 };
        int[] nums5 = new int[] { 0, 0 };
        Solution solution = new Solution();
//        System.out.println(solution.largestNumber(nums1));
//        System.out.println(solution.largestNumber(nums2));
//        System.out.println(solution.largestNumber(nums3));
//        System.out.println(solution.largestNumber(nums4));
        System.out.println(solution.largestNumber(nums5));
    }
}

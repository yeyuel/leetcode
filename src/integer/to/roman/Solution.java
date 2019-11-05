/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package integer.to.roman;

/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/11/5$
 * @since 1.0
 */
public class Solution
{

    public String intToRoman(int num)
    {
        int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
                "V", "IV", "I" };
        StringBuffer sb = new StringBuffer();
        int index = 0;
        while (index < 13)
        {
            while (num >= nums[index])
            {
                sb.append(romans[index]);
                num -= nums[index];
            }
            index ++;
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(1994));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(9));
    }
}

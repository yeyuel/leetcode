/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package title.number;

/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/28$
 * @since 1.0
 */
public class Solution
{
    public int titleToNumber(String s)
    {
        int ans = 0;
        for (int i = 0; i < s.length(); i++)
        {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        String a1 = "A";
        String a2 = "AB";
        String a3 = "ZY";
        System.out.println(solution.titleToNumber(a1));
        System.out.println(solution.titleToNumber(a2));
        System.out.println(solution.titleToNumber(a3));
    }
}

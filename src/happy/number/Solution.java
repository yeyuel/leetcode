/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package happy.number;

/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/9/27$
 * @since 1.0
 */
public class Solution
{
    public int getNext(int n)
    {
        int totalSum = 0;
        while (n > 0)
        {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n)
    {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast)
        {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
}

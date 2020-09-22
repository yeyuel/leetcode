/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package can.complete.circuit;

/**
 * Solution. 134
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/9/21$
 * @since 1.0
 */
public class Solution
{
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        int n = gas.length;
        int totalTank = 0;
        int curTank = 0;
        int startingStation = 0;
        for (int i = 0; i < n; i++)
        {
            totalTank += gas[i] - cost[i];
            curTank += gas[i] - cost[i];
            if (curTank < 0)
            {
                startingStation = i + 1;
                curTank = 0;
            }
        }
        return totalTank >= 0 ? startingStation : -1;
    }

    public static void main(String[] args)
    {
        int[] gas = new int[] { 1, 2, 3, 4, 5 };
        int[] cost = new int[] { 3, 4, 5, 1, 2 };
        System.out.println(new Solution().canCompleteCircuit(gas, cost));
    }
}

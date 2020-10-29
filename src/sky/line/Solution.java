/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package sky.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/29$
 * @since 1.0
 */
public class Solution
{
    public List<List<Integer>> getSkyline(int[][] buildings)
    {
        int n = buildings.length;
        List<List<Integer>> output = new ArrayList<>();
        if (n == 0)
            return output;
        if (n == 1)
        {
            int xStart = buildings[0][0];
            int xEnd = buildings[0][1];
            int y = buildings[0][2];

            output.add(new ArrayList<Integer>() {{add(xStart); add(y); }});
            output.add(new ArrayList<Integer>() {{add(xEnd); add(0); }});

            return output;
        }
        List<List<Integer>> leftSkyline, rightSkyline;
        leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n / 2));
        rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n / 2, n));
        return mergeSkylines(leftSkyline, rightSkyline);
    }

    public List<List<Integer>> mergeSkylines(List<List<Integer>> left,
            List<List<Integer>> right)
    {
        int nL = left.size(), nR = right.size();
        int pL = 0, pR = 0;
        int currY = 0, leftY = 0, rightY = 0;
        int x, maxY;
        List<List<Integer>> output = new ArrayList<>();

        while ((pL < nL) && (pR < nR))
        {
            List<Integer> pointL = left.get(pL);
            List<Integer> pointR = right.get(pR);
            if (pointL.get(0) < pointR.get(0))
            {
                x = pointL.get(0);
                leftY = pointL.get(1);
                pL++;
            }
            else
            {
                x = pointR.get(0);
                rightY = pointR.get(1);
                pR++;
            }
            maxY = Math.max(leftY, rightY);
            if (currY != maxY)
            {
                updateOutput(output, x, maxY);
                currY = maxY;
            }
        }

        appendSkyline(output, left, pL, nL, currY);
        appendSkyline(output, right, pR, nR, currY);
        return output;
    }

    public void updateOutput(List<List<Integer>> output, int x, int y)
    {
        if (output.isEmpty() || output.get(output.size() - 1).get(0) != x)
        {
            output.add(new ArrayList<Integer>()
            {{
                add(x);
                add(y);
            }});
        }
        else
        {
            output.get(output.size() - 1).set(1, y);
        }
    }

    public void appendSkyline(List<List<Integer>> output,
            List<List<Integer>> skyline,
            int p, int n, int currY)
    {
        while (p < n)
        {
            List<Integer> point = skyline.get(p);
            int x = point.get(0);
            int y = point.get(1);
            p++;

            if (currY != y)
            {
                updateOutput(output, x, y);
                currY = y;
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] input = new int[][]{
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}};
        Solution solution = new Solution();
        System.out.println(solution.getSkyline(input));
    }
}

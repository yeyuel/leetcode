/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package sky.line;

import java.util.*;


/**
 * Solution1.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/30$
 * @since 1.0
 */
public class Solution1
{
    public List<List<Integer>> getSkyline(int[][] buildings)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int[] building : buildings)
        {
            pq.offer(new int[] { building[0], -building[2] });
            pq.offer(new int[] { building[1], building[2] });
        }
        List<List<Integer>> res = new ArrayList<>();

        TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);
        heights.put(0, 1);
        int left = 0, height = 0;
        while (!pq.isEmpty())
        {
            int[] arr = pq.poll();
            if (arr[1] < 0)
            {
                heights.put(-arr[1], heights.getOrDefault(-arr[1], 0) + 1);
            }
            else
            {
                heights.put(arr[1], heights.get(arr[1]) - 1);
                if (heights.get(arr[1]) == 0)
                    heights.remove(arr[1]);
            }
            int maxHeight = heights.keySet().iterator().next();
            if (maxHeight != height)
            {
                left = arr[0];
                height = maxHeight;
                res.add(Arrays.asList(left, height));
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[][] input = new int[][]{
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}};
        Solution1 solution = new Solution1();
        System.out.println(solution.getSkyline(input));
    }
}

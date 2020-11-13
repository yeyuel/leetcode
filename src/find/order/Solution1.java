/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package find.order;

import java.util.*;


/**
 * Solution1.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/11/13$
 * @since 1.0
 */
public class Solution1
{
    private int index;

    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
        index = 0;
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
        {
            edges.add(new ArrayList<>());
        }
        int[] result = new int[numCourses];
        int[] outDegree = new int[numCourses];

        for (int[] info : prerequisites)
        {
            edges.get(info[1]).add(info[0]);
            ++outDegree[info[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
        {
            if (outDegree[i] == 0)
            {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty())
        {
            int u = queue.poll();
            result[index++] = u; // first node is the root
            for (Integer v : edges.get(u))
            {
                --outDegree[v];
                if (outDegree[v] == 0)
                {
                    queue.offer(v);
                }
            }
        }
        if (index != numCourses)
        {
            return new int[0];
        }
        return result;
    }

    public static void main(String[] args)
    {
        Solution1 solution = new Solution1();
        int[][] pre1 = new int[][] { { 1, 0 } };
        int[][] pre2 = new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        System.out.println(Arrays.toString(solution.findOrder(2, pre1)));
        System.out.println(Arrays.toString(solution.findOrder(4, pre2)));
    }
}

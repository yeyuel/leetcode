/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package find.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/11/13$
 * @since 1.0
 */
public class Solution
{
    private int index;

    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
        int[] visited = new int[numCourses];
        int[] result = new int[numCourses];
        index = numCourses - 1;
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
        {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites)
        {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses; i++)
        {
            if (visited[i] == 0)
            {
                if (!dfs(i, visited, edges, result))
                {
                    return new int[0];
                }
            }
        }
        return result;
    }

    private boolean dfs(int u, int[] visited, List<List<Integer>> edges,
            int[] result)
    {
        visited[u] = 1;
        for (Integer v : edges.get(u))
        {
            if (visited[v] == 0)
            {
                boolean valid = dfs(v, visited, edges, result);
                if (!valid) return false;
            }
            else if (visited[v] == 1)
            {
                return false;
            }
        }
        visited[u] = 2;
        result[index--] = u; // first node is the leaf
        return true;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[][] pre1 = new int[][] { { 1, 0 } };
        int[][] pre2 = new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        System.out.println(Arrays.toString(solution.findOrder(2, pre1)));
        System.out.println(Arrays.toString(solution.findOrder(4, pre2)));
    }
}

/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package k.th.smallest;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/26$
 * @since 1.0
 */
public class Solution
{
    public int kthSmallest1(int[][] matrix, int k)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[0] - o2[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++)
        {
            pq.offer(new int[] { matrix[i][0], i, 0 });
        }
        for (int i = 0; i < k - 1; i++)
        {
            int[] now = pq.poll();
            if (now[2] != n - 1)
            {
                pq.offer(new int[] { matrix[now[1]][now[2] + 1], now[1],
                        now[2] + 1 });
            }
        }
        return pq.poll()[0];
    }

    public int kthSmallest2(int[][] matrix, int k)
    {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right)
        {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n))
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n)
    {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n)
        {
            if (matrix[i][j] <= mid)
            {
                num += i + 1;
                j++;
            }
            else
            {
                i--;
            }
        }
        return num >= k;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[][] matrix = new int[][] {
                { 1, 5, 9 },
                { 10, 11, 13 },
                { 12, 13, 15 } };
        System.out.println(solution.kthSmallest1(matrix, 8));
        System.out.println(solution.kthSmallest2(matrix, 8));
    }
}

/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package top.k.frequent;

import java.util.*;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/26$
 * @since 1.0
 */
public class Solution
{
    public int[] topKFrequent1(int[] nums, int k)
    {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums)
        {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences
                .entrySet())
        {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k)
            {
                if (queue.peek()[1] < count)
                {
                    queue.poll();
                    queue.offer(new int[] { num, count });
                }
            }
            else
            {
                queue.offer(new int[] { num, count });
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++)
        {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    public int[] topKFrequent2(int[] nums, int k)
    {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums)
        {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : occurrences
                .entrySet())
        {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[] { num, count });
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    public void qsort(List<int[]> values, int start, int end, int[] ret,
            int retIndex, int k)
    {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;

        for(int i = start + 1; i <= end; i++)
        {
            if (values.get(i)[1] >= pivot)
            {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start)
        {
            qsort(values, start, index - 1, ret, retIndex, k);
        }
        else
        {
            for (int i = start; i <= index; i++)
            {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1)
            {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }

    public static void main(String[] args)
    {
        int[] nums1 = new int[] { 1, 1, 1, 2, 2, 3 };
        int[] nums2 = new int[] { 1 };
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent1(nums1, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent1(nums2, 1)));
        System.out.println(Arrays.toString(solution.topKFrequent2(nums1, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent2(nums2, 1)));
    }
}

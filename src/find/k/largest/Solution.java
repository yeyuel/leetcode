/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package find.k.largest;

import java.util.Random;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/21$
 * @since 1.0
 */
public class Solution
{
    Random random = new Random();

    public int findKthLargest1(int[] nums, int k)
    {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index)
    {
        int q = randomPartition(a, l, r);
        if (q == index)
        {
            return a[q];
        }
        else
        {
            return q < index ?
                    quickSelect(a, q + 1, r, index) :
                    quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r)
    {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r)
    {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j)
        {
            if (a[j] <= x)
            {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j)
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public int findKLargest2(int[] nums, int k)
    {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i)
        {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize)
    {
        for (int i = heapSize / 2; i >= 0; i--)
        {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize)
    {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest])
        {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest])
        {
            largest = r;
        }
        if (largest != i)
        {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }


    public static void main(String[] args)
    {
        int[] input1 = new int[] { 3, 2, 1, 5, 6, 4 };
        int[] input2 = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest1(input1, 2));
        System.out.println(solution.findKthLargest1(input2, 4));
        System.out.println(solution.findKLargest2(input1, 2));
        System.out.println(solution.findKLargest2(input2, 4));
    }
}

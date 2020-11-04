/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package playground;

import java.util.Arrays;


/**
 * MergeSort.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/11/2$
 * @since 1.0
 */
public class MergeSort
{
    public void mergeArray(int[] arr, int first, int mid, int last, int tmp[])
    {
        int i = first, j = mid + 1; // two pointer
        int m = mid, n = last; // boundary
        int k = 0; // tmp pointer
        while (i <= m && j <= n)
        {
            if (arr[i] < arr[j])
            {
                tmp[k++] = arr[i++];
            }
            else
            {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= m)
        {
            tmp[k++] = arr[i++];
        }
        while (j <= n)
        {
            tmp[k++] = arr[j++];
        }
        for (i = 0; i < k; i++)
        {
            arr[first + i] = tmp[i];
        }
    }

    public void mergeSort(int[] arr, int first, int last, int tmp[])
    {
        if (first < last)
        {
            int mid = (first + last) >> 1;
            mergeSort(arr, first, mid, tmp);
            mergeSort(arr, mid + 1, last, tmp);
            mergeArray(arr, first, mid, last, tmp);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = new int[] { 5, 2, 6, 2, 7, 5, 6, 10, 10000, 10, 100 };
        new MergeSort().mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }
}

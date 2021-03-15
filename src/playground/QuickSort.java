/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package playground;

import java.util.Arrays;


/**
 * QuickSort.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/11/2$
 * @since 1.0
 */
public class QuickSort
{
    public void quickSort(int[] arr, int l, int r)
    {
        if (l < r)
        {
            int i = l, j = r, x = arr[l];
            while (i < j)
            {
                while (i < j && arr[j] >= x) j--;
                if (i < j) arr[i++] = arr[j];
                while (i < j && arr[i] < x) i++;
                if (i < j) arr[j--] = arr[i];
            }
            arr[i] = x;
            quickSort(arr, l, i - 1);
            quickSort(arr, i + 1, r);
        }
    }

    public int findKthNumber(int[] arr, int k) {
        if (k > arr.length) {
            return -1;
        }
        return search(arr, 0, arr.length - 1, k);
    }

    private int search(int[] arr, int l, int r, int k) {
        int m = partition(arr, l, r);
        if (k == m - l + 1) return arr[m];
        else if (k < m - l + 1) {
            return search(arr, l, m - 1, k);
        } else {
            return search(arr, m + 1, r, k - (m - l + 1));
        }
    }

    private int partition(int[] arr, int l, int r) {
        int i = l;
        if (l < r) {
            int j = r, x = arr[l];
            while (i < j) {
                while (i < j && arr[j] >= x) j--;
                if (i < j) arr[i++] = arr[j];
                while (i < j && arr[i] < x) i++;
                if (i < j) arr[j--] = arr[i];
            }
            arr[i] = x;
        }
        return i;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[] { 5, 2, 6, 2, 7, 5, 6, 10, 10000, 10, 100 };
        new QuickSort().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        arr = new int[] { 5, 2, 6, 2, 7, 5, 6, 10, 10000, 10, 100 };
        System.out.println(new QuickSort().findKthNumber(arr, 7));
    }
}

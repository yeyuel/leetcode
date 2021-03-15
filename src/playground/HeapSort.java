package playground;

import java.util.Arrays;

public class HeapSort {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public void adjustHeap(int[] arr, int i, int length) {
        int tmp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > tmp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }

    public void adjustHeapSmall(int[] arr, int i, int length) {
        int tmp = arr[i];
        for (int k = i * 2 + 1; k < arr.length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] > arr[k + 1]) {
                k ++;
            }
            if (arr[k] < tmp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }

    public int[] maxHeap(int k, int[] inputArr) {
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = inputArr[i];
        }
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, k);
        }
        return arr;
    }

    public int[] minHeap(int k, int[] inputArr) {
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = inputArr[i];
        }
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustHeapSmall(arr, i, k);
        }
        return arr;
    }

    public int findKLarge(int k, int[] inputArr) {
        int[] heapArr = minHeap(k, inputArr);
        for (int i = k; i < inputArr.length; i++) {
            if (inputArr[i] > heapArr[0]) {
                heapArr[0] = inputArr[i];
                adjustHeapSmall(heapArr, 0, k);
            }
        }
        return heapArr[0];
    }

    public int findKSmall(int k, int[] inputArr) {
        int[] heapArr = maxHeap(k, inputArr);
        for (int i = k; i < inputArr.length; i++) {
            if (inputArr[i] < heapArr[0]) {
                heapArr[0] = inputArr[i];
                adjustHeap(heapArr, 0, k);
            }
        }
        return heapArr[0];
    }

    public void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 6, 2, 7, 5, 6, 10, 10000, 10, 100};
        new HeapSort().sort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{5, 2, 6, 2, 7, 5, 6, 10, 10000, 10, 100};
        System.out.println(new HeapSort().findKLarge(7, arr));

        arr = new int[]{5, 2, 6, 2, 7, 5, 6, 10, 10000, 10, 100};
        System.out.println(new HeapSort().findKSmall(7, arr));
    }
}

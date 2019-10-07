package k.closest.number;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return ret;
        }
        int begin = 0, end = arr.length - 1;
        while (end - begin + 1 > k) {
            if (arr[begin] > x) {
                end--;
            } else if (arr[end] < x) {
                begin++;
            } else {
                if (x - arr[begin] > arr[end] - x) {
                    begin++;
                } else {
                    end--;
                }
            }
        }
        for (int i = begin; i <=  end ; i++) {
            ret.add(arr[i]);
        }
        return ret;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> ret = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return ret;
        }
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        for (int i = left; i < left + k; i++) {
            ret.add(arr[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        System.out.println(solution.findClosestElements(input, 4, 3));
        System.out.println(solution.findClosestElements(input, 4, -1));
        System.out.println(solution.findClosestElements2(input, 4, 3));
        System.out.println(solution.findClosestElements2(input, 4, -1));
    }
}

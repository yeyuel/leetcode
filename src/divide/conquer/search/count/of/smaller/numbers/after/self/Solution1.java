package divide.conquer.search.count.of.smaller.numbers.after.self;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> count = new ArrayList<>(nums.length);
        int[][] vec = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            vec[i] = new int[]{nums[i], i};
            count.add(0);
        }
        mergeSort(vec, 0, nums.length - 1, count);
        return count;
    }

    private void mergeSort(int[][] vec,
                           int start,
                           int end,
                           List<Integer> count) {
        if (start < end) {
            int mid = (end + start) >> 1;
            int[][] tmp = new int[vec.length][2];
            mergeSort(vec, start, mid, count);
            mergeSort(vec, mid + 1, end, count);
            mergeVec(vec, start, mid, end, tmp, count);
        }
    }

    private void mergeVec(int[][] vec, int start, int mid, int last, int[][] tmp,
                          List<Integer> count) {
        int i = start, j = mid + 1;
        int m = mid, n = last;
        int k = 0;
        while (i <= m && j <= n) {
            if (vec[i][0] <= vec[j][0]) {
                int i1 = vec[i][1];
                count.set(i1, count.get(i1) + j - mid - 1);
                tmp[k++] = vec[i++];
            } else {
                tmp[k++] = vec[j++];
            }
        }
        while (i <= m) {
            int i1 = vec[i][1];
            count.set(i1, count.get(i1) + j - mid - 1);
            tmp[k++] = vec[i++];
        }
        while (j <= m) {
            tmp[k++] = vec[j++];
        }
        for (i = 0; i < k; i++) {
            vec[start + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] sample = new int[] {5,2,6,1};
        System.out.println(solution.countSmaller(sample));
    }
}

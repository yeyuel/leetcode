package divide.conquer.search.range;

import java.util.Arrays;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        result[0] = leftBound(nums, target);
        result[1] = rightBound(nums, target);
        return result;
    }

    int leftBound(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (target == nums[mid]) {
                if (mid == 0|| nums[mid - 1] < target) {
                    return mid;
                }
                end = mid - 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                begin = mid + 1;
            }
        }
        return -1;
    }

    int rightBound(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (target == nums[mid]) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid;
                }
                begin = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                begin = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sample1 = new int[] {5,7,7,8,8,10};
        int[] sample2 = new int[] {5,7,7,8,8,10};
        System.out.println(Arrays.toString(solution.searchRange(sample1, 8)));
        System.out.println(Arrays.toString(solution.searchRange(sample2, 6)));
    }
}

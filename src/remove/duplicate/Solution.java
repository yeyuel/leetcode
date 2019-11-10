package remove.duplicate;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left ++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));
        System.out.println(solution.removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
    }
}

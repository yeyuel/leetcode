package three.sum.smaller;

import java.util.Arrays;

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                if (nums[i] + nums[begin] + nums[end] < target) {
                    ret += end - begin;
                    begin ++;
                } else {
                    end --;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        System.out.println(new Solution().threeSumSmaller(nums, target));
    }
}

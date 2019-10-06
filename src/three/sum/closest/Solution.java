package three.sum.closest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                int newSum = nums[i] + nums[begin] + nums[end];
                if (Math.abs(target - newSum) < Math.abs(target - sum)) {
                    sum = newSum;
                }
                if (newSum < target) {
                    begin++;
                } else if (newSum > target) {
                    end--;
                } else {
                    return newSum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new Solution().threeSumClosest(nums, target));
    }
}

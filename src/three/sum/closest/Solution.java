package three.sum.closest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int begin = i + 1;
            int end = nums.length - 1;
            int rangeMin = nums[i] + nums[begin] + nums[begin + 1];
            int rangeMax = nums[i] + nums[end] + nums[end - 1];

            if (rangeMin > target) {
                if (rangeMin - target < min) {
                    min = rangeMin - target;
                    sum = rangeMin;
                }
            } else if (rangeMax < target) {
                if (target - rangeMax < min) {
                    min = target - rangeMax;
                    sum = rangeMax;
                }
            } else {
                while (begin < end) {
                    int newSum = nums[i] + nums[begin] + nums[end];
                    if (Math.abs(target - newSum) < min) {
                        sum = newSum;
                        min = Math.abs(target - newSum);
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
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new Solution().threeSumClosest(nums, target));
    }
}

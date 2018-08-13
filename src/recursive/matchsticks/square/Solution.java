package recursive.matchsticks.square;

import java.util.Arrays;

public class Solution {

    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 4 > 0) {
            return false;
        }
        Arrays.sort(nums);
        int[] bucket = new int[4];
        return generate(0, nums, sum / 4, bucket);
    }

    boolean generate(int i, int[] nums, int target, int[] bucket) {
        if (i >= nums.length) {
            return bucket[0] == target &&
                    bucket[1] == target &&
                    bucket[2] == target &&
                    bucket[3] == target;
        }
        for (int j = 0; j < 4; j++) {
            if (bucket[j] + nums[i] > target) {
                continue;
            }
            bucket[j] += nums[i];
            if (generate(i + 1, nums, target, bucket)) {
                return true;
            }
            bucket[j] -= nums[i];
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sample1 = new int[] {1, 1, 2, 2, 2};
        int[] sample2 = new int[] {3, 3, 4, 4, 4};
        int[] sample3 = new int[] {1, 1, 2, 4, 3, 2, 3};
        System.out.println(solution.makesquare(sample1));
        System.out.println(solution.makesquare(sample2));
        System.out.println(solution.makesquare(sample3));
    }
}

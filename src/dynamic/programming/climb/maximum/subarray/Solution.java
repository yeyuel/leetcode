package dynamic.programming.climb.maximum.subarray;

public class Solution {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxRes = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (maxRes < dp[i]) {
                maxRes = dp[i];
            }
        }
        return maxRes;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sample = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(sample));
    }
}

package dynamic.programming.longest.increasing.sequence;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int lis = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (lis < dp[i]) {
                lis = dp[i];
            }
        }
        return lis;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sample = {10,9,2,5,3,7,101,18};
        System.out.println(solution.lengthOfLIS(sample));
    }
}

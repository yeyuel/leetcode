package dynamic.programming.climb.stairs;

public class Solution {

    public int climbStairs(int n) {
        int[] dp = new int[n + 3];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public int climStairsForce(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(10));
        System.out.println(solution.climStairsForce(10));
    }
}

package dynamic.programming.coin.change;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int leftCoin = i - coins[j];
                if (leftCoin >= 0 && dp[leftCoin] != -1) {
                    if (dp[i] == -1 || dp[i] > dp[leftCoin] + 1)
                    {
                        dp[i] = dp[leftCoin] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int[] coins2 = {2};
        int amount2 = 3;
        Solution solution = new Solution();
        System.out.println(solution.coinChange(coins1, amount1));
        System.out.println(solution.coinChange(coins2, amount2));
    }
}

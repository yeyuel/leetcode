package num.squares;

import java.util.Arrays;

public class Solution {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int maxSquareIndex = (int) Math.sqrt(n) + 1;
        int[] squareNums = new int[maxSquareIndex];
        for (int i = 1; i < maxSquareIndex; i++) {
            squareNums[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s < maxSquareIndex; s++) {
                if (i < squareNums[s])
                    break;
                dp[i] = Math.min(dp[i], dp[i - squareNums[s]] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
        System.out.println(solution.numSquares(13));
    }
}

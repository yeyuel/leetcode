package dynamic.programming.dungeon.game;

public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0) {
            return 0;
        }
        int row = dungeon.length;
        int column = dungeon[0].length;
        int[][] dp = new int[row][column];
        dp[row - 1][column - 1] = Math.max(1, 1 - dungeon[row - 1][column - 1]);

        for (int i = column - 2; i >= 0; i--) {
            dp[row - 1][i] = Math.max(1, dp[row - 1][i + 1] - dungeon[row - 1][i]);
        }
        for (int i = row - 2; i >= 0; i--) {
            dp[i][column - 1] = Math.max(1, dp[i + 1][column - 1] - dungeon[i][column - 1]);
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = column - 2; j >= 0; j--) {
                int dpMin = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, dpMin - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] sample = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(solution.calculateMinimumHP(sample));
    }
}

package dynamic.programming.triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size()];
        int lastRow = triangle.size() - 1;
        for (int i = 0; i < triangle.get(lastRow).size(); i++) {
            dp[i] = triangle.get(lastRow).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> sample = new ArrayList<>();
        sample.add(Arrays.asList(new Integer[]{2}));
        sample.add(Arrays.asList(new Integer[]{3,4}));
        sample.add(Arrays.asList(new Integer[]{6,5,7}));
        sample.add(Arrays.asList(new Integer[]{4,1,8,3}));
        Solution solution = new Solution();
        System.out.println(solution.minimumTotal(sample));
    }
}

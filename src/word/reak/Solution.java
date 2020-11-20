package word.reak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList(new String[]{"leet", "code"});

        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList(new String[]{"apple", "pen"});

        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s1, wordDict1));
        System.out.println(solution.wordBreak(s2, wordDict2));
    }
}

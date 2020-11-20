/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package word.reak.two;

import java.util.*;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/11/20$
 * @since 1.0
 */
public class Solution
{
    public List<String> wordBreak(String s, List<String> wordDict)
    {
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> wordBreaks = backtrack(s, s.length(),
                new HashSet<>(wordDict), 0, map);
        List<String> breakList = new LinkedList<>();
        for (List<String> wordBreak : wordBreaks)
        {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    private List<List<String>> backtrack(String s, int length,
            Set<String> wordSet, int index,
            Map<Integer, List<List<String>>> map)
    {
        if (!map.containsKey(index))
        {
            List<List<String>> wordBreaks = new LinkedList<>();
            if (index == length)
            {
                wordBreaks.add(new LinkedList<>());
            }
            for (int i = index + 1; i <= length; i++)
            {
                String word = s.substring(index, i);
                if (wordSet.contains(word))
                {
                    List<List<String>> nextWordBreaks = backtrack(s, length,
                            wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks)
                    {
                        LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        String s1 = "catsanddog";
        List<String> wordDict1 = Arrays
                .asList("cat", "cats", "and", "sand", "dog");
        String s2 = "pineapplepenapple";
        List<String> wordDict2 = Arrays
                .asList("apple", "pen", "applepen", "pine",
                        "pineapple");
        System.out.println(solution.wordBreak(s1, wordDict1));
        System.out.println(solution.wordBreak(s2, wordDict2));
    }
}

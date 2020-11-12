/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package breadth.first.search.word.ladder;

import java.util.*;


/**
 * Solution2.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/11/12$
 * @since 1.0
 */
public class Solution2
{
    Map<String, Integer> worldId = new HashMap<>();
    List<List<Integer>> edge = new ArrayList<>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord,
            List<String> wordList)
    {
        for (String word : wordList)
        {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!worldId.containsKey(endWord))
        {
            return 0;
        }
        int[] disBegin = new int[nodeNum];
        Arrays.fill(disBegin, Integer.MAX_VALUE);
        int beginId = worldId.get(beginWord);
        disBegin[beginId] = 0;
        Queue<Integer> queBegin = new LinkedList<>();
        queBegin.offer(beginId);

        int[] disEnd = new int[nodeNum];
        Arrays.fill(disEnd, Integer.MAX_VALUE);
        int endId = worldId.get(endWord);
        disEnd[endId] = 0;
        Queue<Integer> queEnd = new LinkedList<>();
        queEnd.offer(endId);

        while (!queBegin.isEmpty() && !queEnd.isEmpty())
        {
            int queBeginSize = queBegin.size();
            for (int i = 0; i < queBeginSize; i++)
            {
                int nodeBegin = queBegin.poll();
                if (disEnd[nodeBegin] != Integer.MAX_VALUE)
                {
                    return (disBegin[nodeBegin] + disEnd[nodeBegin]) / 2 + 1;
                }
                for (Integer it : edge.get(nodeBegin))
                {
                    if (disBegin[it] == Integer.MAX_VALUE)
                    {
                        disBegin[it] = disBegin[nodeBegin] + 1;
                        queBegin.offer(it);
                    }
                }
            }

            int queEndSize = queEnd.size();
            for (int i = 0; i < queEndSize; i++)
            {
                int nodeEnd = queEnd.poll();
                if (disBegin[nodeEnd] != Integer.MAX_VALUE)
                {
                    return (disBegin[nodeEnd] + disEnd[nodeEnd]) / 2 + 1;
                }
                for (Integer it : edge.get(nodeEnd))
                {
                    if (disEnd[it] == Integer.MAX_VALUE)
                    {
                        disEnd[it] = disEnd[nodeEnd] + 1;
                        queEnd.offer(it);
                    }
                }
            }
        }
        return 0;
    }

    public void addEdge(String word)
    {
        addWord(word);
        int id1 = worldId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; i++)
        {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = worldId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word)
    {
        if (!worldId.containsKey(word))
        {
            worldId.put(word, nodeNum++);
            edge.add(new ArrayList<>());
        }
    }

    public static void main(String[] args)
    {
        String[] wordList1 = new String[] { "hot", "dot", "dog", "lot", "log",
                "cog" };
        String[] wordList2 = new String[] { "hot", "dot", "dog", "lot", "log" };
        System.out.println(new Solution2().ladderLength("hit", "cog", Arrays.asList(wordList1)));
        System.out.println(new Solution2().ladderLength("hit", "cog", Arrays.asList(wordList2)));
    }
}

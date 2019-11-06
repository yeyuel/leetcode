/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package longest.common.prefix;

/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/11/5$
 * @since 1.0
 */
public class Solution
{
    public String longestCommonPrefix(String[] strs)
    {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++)
        {
            while (strs[i].indexOf(prefix) != 0)
            {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix1(String[] strs)
    {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++)
        {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++)
            {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix2(String[] strs)
    {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix2(strs, 0, strs.length - 1);
    }

    public String longestCommonPrefix2(String[] strs, int l, int r)
    {
        if (l == r)
        {
            return strs[l];
        }
        else
        {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix2(strs, l, mid);
            String lcpRight = longestCommonPrefix2(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left, String right)
    {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++)
        {
            if (left.charAt(i) != right.charAt(i))
            {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

    public String longestCommonPrefix(String q, String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return "";
        }
        if (strs.length == 1)
        {
            return strs[0];
        }
        Trie trie = new Trie();
        for (int i = 0; i < strs.length; i++)
        {
            trie.insert(strs[i]);
        }
        return trie.searchLongestPrefix(q);
    }

    class TrieNode
    {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        private int size;

        public TrieNode()
        {
            links = new TrieNode[R];
        }

        public int getLinks()
        {
            return size;
        }

        public boolean containsKey(char ch)
        {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch)
        {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node)
        {
            links[ch - 'a'] = node;
            size++;
        }

        public void setEnd()
        {
            isEnd = true;
        }

        public boolean isEnd()
        {
            return isEnd;
        }
    }

    public class Trie
    {
        private TrieNode root;

        public Trie()
        {
            root = new TrieNode();
        }

        public void insert(String word)
        {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++)
            {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar))
                {
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        private TrieNode searchPrefix(String word)
        {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++)
            {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter))
                {
                    node = node.get(curLetter);
                }
                else
                {
                    return null;
                }
            }
            return node;
        }

        public boolean search(String word)
        {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        public boolean startsWith(String prefix)
        {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }

        private String searchLongestPrefix(String word)
        {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < word.length(); i++)
            {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter) && node.getLinks() == 1 && !node.isEnd)
                {
                    prefix.append(curLetter);
                    node = node.get(curLetter);
                }
                else
                {
                    return prefix.toString();
                }
            }
            return prefix.toString();
        }
    }

    public static void main(String[] args)
    {
        String[] sample1 = { "flower", "flow", "flight" };
        String[] sample2 = { "dog", "racecar", "car" };
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix3(sample1));
        System.out.println(solution.longestCommonPrefix3(sample2));
        System.out.println(solution.longestCommonPrefix(sample1[0], sample1));
        System.out.println(solution.longestCommonPrefix(sample2[0], sample2));
    }
}

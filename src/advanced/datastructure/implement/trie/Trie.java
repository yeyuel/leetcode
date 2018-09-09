package advanced.datastructure.implement.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private static final int MAX_CHAR_NUM = 26;

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
        public TrieNode(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }

    TrieNode root = newNode();

    private TrieNode newNode() {
        TrieNode node = new TrieNode(false);
        return node;
    }

    /** Initialize your data structure here. */
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ptr = this.root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (ptr.child[pos] == null) {
                ptr.child[pos] = newNode();
            }
            ptr = ptr.child[pos];
        }
        ptr.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ptr = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (ptr.child[pos] == null) {
                return false;
            }
            ptr = ptr.child[pos];
        }
        return ptr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int pos = prefix.charAt(i) - 'a';
            if (ptr.child[pos] == null) {
                return false;
            }
            ptr = ptr.child[pos];
        }
        return true;
    }

    private List<String> getAllWordFromTrie() {
        ArrayList<String> wordList = new ArrayList<>();
        getAllWordFromTrie(root, new StringBuffer(), wordList);
        return wordList;
    }

    private void getAllWordFromTrie(TrieNode node, StringBuffer sb, List<String> wordList) {
        for (int i = 0; i < MAX_CHAR_NUM; i++) {
            if (node.child[i] != null) {
                sb.append((char) (i + 'a'));
                if (node.child[i].isEnd) {
                    wordList.add(sb.toString());
                }
                getAllWordFromTrie(node.child[i], sb, wordList);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println(trie.getAllWordFromTrie());
    }
}

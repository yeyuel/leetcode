package advanced.datastructure.add.and.search.word;

public class WordDictionary {

    private static final int MAX_NUM = 26;

    private TrieNode root;

    class TrieNode {
        TrieNode[] children = new TrieNode[MAX_NUM];
        boolean isEnd;
        public TrieNode(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode(false);
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode ptr = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (ptr.children[pos] == null) {
                ptr.children[pos] = new TrieNode(false);
            }
            ptr = ptr.children[pos];
        }
        ptr.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchTrie(root, word, 0);
    }

    private boolean searchTrie(TrieNode node, String word, int index) {
        if (index == word.length()) {
            if (node.isEnd) {
                return true;
            }
            return false;
        }
        if ('.' == (word.charAt(index))) {
            for (int i = 0; i < MAX_NUM; i++) {
                if (node.children[i] != null && searchTrie(node.children[i], word, index + 1)) {
                    return true;
                }
            }
        } else {
            int pos = word.charAt(index) - 'a';
            if (node.children[pos] != null && searchTrie(node.children[pos], word, index + 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        String apple = "apple";
        dictionary.addWord(apple);
        String dad = "dad";
        dictionary.addWord(dad);
        String bad = "bad";
        dictionary.addWord(bad);
        String mad = "mad";
        dictionary.addWord(mad);
        dictionary.addWord("a");
        System.out.println(dictionary.search(apple));
        System.out.println(dictionary.search(dad));
        System.out.println(dictionary.search(mad));
        System.out.println(dictionary.search("pad"));
        System.out.println(dictionary.search(".ad"));
        System.out.println(dictionary.search("b.."));
        System.out.println(dictionary.search("."));
    }
}

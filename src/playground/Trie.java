package playground;

public class Trie {
    private Trie[] children;
    private boolean end;

    public Trie() {
        children = new Trie[26];
        end = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) node.children[index] = new Trie();
            node = node.children[index];
        }
        node.end = true;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.end;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) return null;
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("helloworld");
        trie.insert("hello");
        System.out.println(trie.search("hello"));
        System.out.println(trie.startsWith("hellow"));
    }
}

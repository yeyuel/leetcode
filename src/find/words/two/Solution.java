package find.words.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;

        public TrieNode() {}
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (char letter : word.toCharArray()) {
                if (!node.children.containsKey(letter)) {
                    node.children.put(letter, new TrieNode());
                }
                node = node.children.get(letter);
            }
            node.word = word;
        }
        return root;
    }

    private void backtracking(char[][] board, int row, int col, TrieNode parent, List<String> result) {
        char letter = board[row][col];
        TrieNode currentNode = parent.children.get(letter);

        if (currentNode.word != null) {
            result.add(currentNode.word);
            currentNode.word = null;
        }

        board[row][col] = '#';
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[row].length) {
                continue;
            }
            if (currentNode.children.containsKey(board[newRow][newCol])) {
                backtracking(board, newRow, newCol, currentNode, result);
            }
        }
        board[row][col] = letter;
        if (currentNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }


    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtracking(board, i, j, root, result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] board1 = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words1 = new String[]{"oath", "pea", "eat", "rain"};

        char[][] board2 = new char[][]{
                {'a', 'b'},
                {'c', 'd'}
        };
        String[] words2 = new String[]{"abcb"};

        char[][] board3 = new char[][]{
                {'a', 'b'}
        };
        String[] words3 = new String[]{"ab"};

        Solution solution = new Solution();
//        System.out.println(solution.findWords(board1, words1));
//        System.out.println(solution.findWords(board2, words2));
        System.out.println(solution.findWords(board3, words3));
    }
}

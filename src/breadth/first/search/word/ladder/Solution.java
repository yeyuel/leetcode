package breadth.first.search.word.ladder;

import java.util.*;

public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = constructMap(beginWord, wordList);
        return bfs(beginWord, endWord, graph);
    }

    class WordPoint {
        String word;
        int cnt;

        public WordPoint(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }


    private int bfs(String beginWord, String endWord,
                    Map<String, List<String>> graph) {
        LinkedList<WordPoint> queue = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        queue.add(new WordPoint(beginWord, 1));
        visit.add(beginWord);
        while (!queue.isEmpty()) {
            WordPoint wordPoint = queue.poll();
            String word = wordPoint.word;
            int step = wordPoint.cnt;
            if (word.equals(endWord)) {
                return step;
            }
            List<String> neighbors = graph.get(word);
            for (String neighbor: neighbors) {
                if (!visit.contains(neighbor)) {
                    queue.add(new WordPoint(neighbor, step + 1));
                    visit.add(neighbor);
                }
            }
        }
        return 0;
    }

    private Map<String, List<String>> constructMap(String beginWord,
                              List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        wordList = new ArrayList<>(wordList);
        wordList.add(beginWord);
        for (int i = 0; i < wordList.size(); i++) {
            graph.put(wordList.get(i), new ArrayList<>());
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (connect(wordList.get(i), wordList.get(j))) {
                    graph.get(wordList.get(i)).add(wordList.get(j));
                    graph.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        return graph;
    }

    private boolean connect(String word1, String word2) {
        int cnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                cnt ++;
            }
        }
        return cnt == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        Solution solution = new Solution();
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}

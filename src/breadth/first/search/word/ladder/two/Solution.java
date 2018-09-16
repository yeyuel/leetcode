package breadth.first.search.word.ladder.two;

import java.util.*;

public class Solution {

    class QItem {
        String node;
        int parentPos;
        int step;

        public QItem(String node, int parentPos, int step) {
            this.node = node;
            this.parentPos = parentPos;
            this.step = step;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> pathList = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        LinkedList<QItem> queue = new LinkedList<>();
        List<Integer> endWordPos = new ArrayList<>();

        constructGraph(beginWord, wordList, graph);
        bfsGraph(beginWord, endWord, graph, queue, endWordPos);
        for (int i = 0; i < endWordPos.size(); i++) {
            int pos = endWordPos.get(i);
            List<String> path = new ArrayList<>();
            while (pos != -1) {
                QItem qItem = queue.get(pos);
                path.add(qItem.node);
                pos = qItem.parentPos;
            }
            Collections.reverse(path);
            pathList.add(path);
        }
        return pathList;
    }

    private void bfsGraph(String beginWord, String endWord,
                                   Map<String, List<String>> graph,
                                   LinkedList<QItem> queue,
                                   List<Integer> endWordPos) {
        Map<String, Integer> visit = new HashMap<>();
        int minStep = 0;
        queue.add(new QItem(beginWord, -1, 1));
        visit.put(beginWord, 1);
        int front = 0;
        while (front != queue.size()) {
            QItem current = queue.get(front);
            String node = current.node;
            int step = current.step;
            if (minStep != 0 && step > minStep) {
                break;
            }
            if (node == endWord) {
                minStep = step;
                endWordPos.add(front);
            }
            List<String> neighbors = graph.get(node);
            for (String neighbor : neighbors) {
                if (!visit.containsKey(neighbor) ||
                        visit.get(neighbor) == step + 1) {
                    queue.add(new QItem(neighbor, front, step + 1));
                    visit.put(neighbor, step + 1);
                }
            }
            front ++;
        }
    }

    private void constructGraph(String beginWord, List<String> wordList, Map<String, List<String>> graph) {
        boolean hasBeginWord = false;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(beginWord)) {
                hasBeginWord = true;
            }
            graph.put(wordList.get(i), new LinkedList<>());
        }
        if (!hasBeginWord) {
            graph.put(beginWord, new LinkedList<>());
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (connect(wordList.get(i), wordList.get(j))) {
                    graph.get(wordList.get(i)).add(wordList.get(j));
                    graph.get(wordList.get(j)).add(wordList.get(i));
                }
            }
            if (!hasBeginWord && connect(beginWord, wordList.get(i))) {
                graph.get(beginWord).add(wordList.get(i));
            }
        }
    }

    private boolean connect(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count ++;
            }
        }
        return count == 1;
    }


    public static void main(String[] args) {
        List<String> wordList1 = Arrays.asList("hot","dot","dog","lot","log","cog");
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList2 = Arrays.asList("hot","dot","dog","lot","log");
        String beginWord2 = "hit";
        String endWord2 = "cog";
        Solution solution = new Solution();
        System.out.println(solution.findLadders(beginWord1, endWord1, wordList1));
        System.out.println(solution.findLadders(beginWord2, endWord2, wordList2));
    }
}

package lfu.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LFUCache {

    class Node implements Comparable {
        int cnt;
        int time;
        int key;
        int value;


        public Node(int cnt, int time, int key, int value) {
            this.cnt = cnt;
            this.time = time;
            this.key = key;
            this.value = value;
        }


        @Override
        public int compareTo(Object o) {
            Node other = (Node) o;
            return cnt == other.cnt ? time - other.time : cnt - other.cnt;
        }
    }

    private int capacity, time;
    Map<Integer, Node> cache;
    TreeSet<Node> nodeSet;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        nodeSet = new TreeSet<>();
    }

    public int get(int key) {
        if (capacity == 0) return -1;
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        nodeSet.remove(node);
        node.cnt += 1;
        node.time = ++time;
        nodeSet.add(node);
        cache.put(key, node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (!cache.containsKey(key)) {
            if (cache.size() == capacity) {
                Node first = (Node) ((TreeSet) nodeSet).first();
                nodeSet.remove(first);
                cache.remove(first.key);
            }
            Node newNode = new Node(1, ++time, key, value);
            cache.put(key, newNode);
            nodeSet.add(newNode);
        } else {
            Node node = cache.get(key);
            cache.remove(node);
            node.cnt += 1;
            node.time = ++time;
            node.value = value;
            nodeSet.add(node);
            cache.put(key, node);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));      // 返回 1
        cache.put(3, 3);    // 去除 key 2
        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(4));       // 返回 4

    }
}

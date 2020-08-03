/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package lfu.cache;

import java.util.HashMap;
import java.util.Map;


/**
 * LFUCache2.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/8/3$
 * @since 1.0
 */
public class LFUCache2
{
    Map<Integer, Node> cache;
    DLinkedList first, last;
    int size, capacity;

    public LFUCache2(int capacity)
    {
        cache = new HashMap<>(capacity);
        first = new DLinkedList(0);
        last = new DLinkedList(0);
        first.post = last; last.pre = first;
        this.capacity = capacity;
    }

    public int get(int key)
    {
        Node node = cache.get(key);
        if (node == null) return -1;
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value)
    {
        if (capacity == 0) return;
        Node node = cache.get(key);
        if (node != null)
        {
            node.value = value;
            freqInc(node);
        }
        else
        {
            if (size == capacity)
            {
                cache.remove(last.pre.tail.pre.key);
                last.removeNode(last.pre.tail.pre);
                size--;
                if (last.pre.head.next == last.pre.tail)
                {
                    removeDlinkedList(last.pre);
                }
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            if (last.pre.freq != 1)
            {
                DLinkedList dLinkedList = new DLinkedList(1);
                addDlinkedList(dLinkedList, last.pre);
                dLinkedList.addNode(newNode);
            }
            else
            {
                last.pre.addNode(newNode);
            }
            size++;
        }
    }

    void freqInc(Node node)
    {
        DLinkedList linkedList = node.dlist;
        DLinkedList preList = linkedList.pre;
        linkedList.removeNode(node);
        if (linkedList.head.next == linkedList.tail)
        {
            removeDlinkedList(linkedList);
        }
        node.freq++;
        if (preList.freq != node.freq)
        {
            DLinkedList newList = new DLinkedList(node.freq);
            addDlinkedList(newList, preList);
            newList.addNode(node);
        }
        else
        {
            preList.addNode(node);
        }
    }

    void addDlinkedList(DLinkedList newList, DLinkedList preList)
    {
        newList.post = preList.post;
        newList.post.pre = newList;
        newList.pre = preList;
        preList.post = newList;
    }

    void removeDlinkedList(DLinkedList dLinkedList)
    {
        dLinkedList.pre.post = dLinkedList.post;
        dLinkedList.post.pre = dLinkedList.pre;
    }


    class Node
    {
        int key, value, freq=1;
        Node pre, next;
        DLinkedList dlist;

        public Node()
        {
        }

        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    class DLinkedList
    {
        int freq;
        DLinkedList pre, post;
        Node head;
        Node tail;

        public DLinkedList(int freq)
        {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            this.freq = freq;
        }

        void removeNode(Node node)
        {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        void addNode(Node node)
        {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
            node.dlist = this;
        }
    }

    public static void main(String[] args)
    {

        LFUCache2 cache = new LFUCache2(2);

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

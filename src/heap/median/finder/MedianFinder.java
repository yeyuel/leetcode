package heap.median.finder;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    private Queue<Integer> smallQueue;
    private Queue<Integer> bigQueue;

    /** initialize your data structure here. */
    public MedianFinder() {
        Comparator<Integer> comparator = Integer::compareTo;
        smallQueue = new PriorityQueue<>(comparator); // 小顶堆存大的部分
        bigQueue = new PriorityQueue<>(comparator.reversed()); // 大顶堆存小的部分
    }

    public void addNum(int num) {
        if (bigQueue.isEmpty()) {
            bigQueue.add(num);
            return;
        }
        if (bigQueue.size() == smallQueue.size()) {
            if (num < bigQueue.peek()) {
                bigQueue.add(num);
            } else {
                smallQueue.add(num);
            }
        } else if (bigQueue.size() > smallQueue.size()) {
            if (num > bigQueue.peek()) {
                smallQueue.add(num);
            } else {
                smallQueue.add(bigQueue.poll());
                bigQueue.add(num);
            }
        } else if (bigQueue.size() < smallQueue.size()) {
            if (num < smallQueue.peek()) {
                bigQueue.add(num);
            } else {
                bigQueue.add(smallQueue.poll());
                smallQueue.add(num);
            }
        }
    }

    public double findMedian() {
        if (bigQueue.size() == smallQueue.size()) {
            return (bigQueue.peek() + smallQueue.peek()) * 1.0 / 2;
        } else if (bigQueue.size() > smallQueue.size()) {
            return bigQueue.peek();
        } else {
            return smallQueue.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(-1);
        System.out.println(finder.findMedian());
        finder.addNum(-2);
        System.out.println(finder.findMedian());
        finder.addNum(-3);
        System.out.println(finder.findMedian());
        finder.addNum(-4);
        System.out.println(finder.findMedian());
        finder.addNum(-5);
        System.out.println(finder.findMedian());
    }
}

package heap.k.largest;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(k, Integer::compareTo);
        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else if (num > heap.peek()) {
                heap.poll();
                heap.add(num);
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int[] test1 = new int[] {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        int[] test2 = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;

        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(test1, k1));
        System.out.println(solution.findKthLargest(test2, k2));
    }
}

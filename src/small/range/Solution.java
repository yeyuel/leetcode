package small.range;

import java.util.*;

/**
 * 632
 */
public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int left = 0, right = Integer.MAX_VALUE;
        int minRange = right - left;
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        int[] next = new int[size];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(i -> nums.get(i).get(next[i])));
        for (int i = 0; i < size; i++) {
            minHeap.add(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (true) {
            int minIndex = minHeap.poll();
            int curRange = max - nums.get(minIndex).get(next[minIndex]);
            if (curRange < minRange) {
                minRange = curRange;
                left = nums.get(minIndex).get(next[minIndex]);
                right = max;
            }
            next[minIndex]++;
            if (next[minIndex] == nums.get(minIndex).size()) {
                break;
            }
            minHeap.add(minIndex);
            max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));
        System.out.println(Arrays.toString(new Solution().smallestRange(nums)));
    }
}

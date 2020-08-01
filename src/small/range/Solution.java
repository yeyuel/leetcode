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

    public int[] smallestRange1(List<List<Integer>> nums) {
        int size = nums.size();
        Map<Integer, List<Integer>> indices = new HashMap<>();
        int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            for (Integer x : nums.get(i)) {
                List<Integer> list = indices.getOrDefault(x, new ArrayList<>());
                list.add(i);
                indices.put(x, list);
                xMin = Math.min(xMin, x);
                xMax = Math.max(xMax, x);
            }
        }
        int[] freq = new int[size];
        int inside = 0;
        int left = xMin, right = xMin - 1;
        int bestLeft = xMin, bestRight = xMax;
        while (right < xMax) {
            right ++;
            if (indices.containsKey(right)) {
                for (Integer x : indices.get(right)) {
                    freq[x]++;
                    if (freq[x] == 1) {
                        inside++;
                    }
                }
                while (inside == size) {
                    if (right - left < bestRight - bestLeft) {
                        bestLeft = left;
                        bestRight = right;
                    }
                    if (indices.containsKey(left)) {
                        for (int x : indices.get(left)) {
                            freq[x]--;
                            if (freq[x] == 0) {
                                inside --;
                            }
                        }
                    }
                    left++;
                }
            }
        }
        return new int[]{bestLeft, bestRight};
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));
        System.out.println(Arrays.toString(new Solution().smallestRange(nums)));
        System.out.println(Arrays.toString(new Solution().smallestRange1(nums)));
    }
}

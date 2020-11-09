package longest.consecutive;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int longestConsecutive1(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (Integer num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public int longestConsecutive2(int[] nums) {
        Map<Integer, Integer> hashDict = new HashMap<>();
        int maxLength = 0;
        for (int num : nums) {
            if (!hashDict.containsKey(num)) {
                int left = hashDict.getOrDefault(num - 1, 0);
                int right = hashDict.getOrDefault(num + 1, 0);
                int curLength = 1 + left + right;
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                hashDict.put(num, curLength);
                hashDict.put(num - left, curLength);
                hashDict.put(num + right, curLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{100, 4, 200, 1, 3, 2};
        int[] nums2 = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(solution.longestConsecutive1(nums1));
        System.out.println(solution.longestConsecutive1(nums2));
        System.out.println(solution.longestConsecutive2(nums1));
        System.out.println(solution.longestConsecutive2(nums2));
    }
}

package longest.consecutive;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int longestConsecutive(int[] nums) {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{100, 4, 200, 1, 3, 2};
        int[] nums2 = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(solution.longestConsecutive(nums1));
        System.out.println(solution.longestConsecutive(nums2));
    }
}

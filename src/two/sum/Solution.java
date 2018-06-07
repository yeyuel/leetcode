package two.sum;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (cache.containsKey(remain)) {
                return new int[]{cache.get(remain), i};
            }
            cache.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] testNums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution().twoSum(testNums, target)));
    }
}

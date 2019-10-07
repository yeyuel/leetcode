package four.sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new LinkedList<>();
        if (nums == null || nums.length < 4) {
            return ret;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int begin = j + 1;
                int end = nums.length - 1;

                // optimize performance
                int rangeMin = nums[i] + nums[j] + nums[begin] + nums[begin + 1];
                int rangeMax = nums[i] + nums[j] + nums[end] + nums[end - 1];
                if (rangeMin > target || rangeMax < target) {
                    continue;
                }
                while (begin < end) {
                    int currentSum = nums[i] + nums[j] + nums[begin] + nums[end];
                    if (currentSum == target) {
                        List<Integer> solution = new LinkedList<>();
                        solution.add(nums[i]);
                        solution.add(nums[j]);
                        solution.add(nums[begin]);
                        solution.add(nums[end]);
                        ret.add(solution);
                        begin ++;
                        end --;
                        while (begin < end && nums[begin] == nums[begin - 1]) {
                            begin ++;
                        }
                        while (begin < end && nums[end] == nums[end + 1]) {
                            end --;
                        }
                    } else if (currentSum < target) {
                        begin ++;
                    } else {
                        end --;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(new Solution().fourSum(nums,  target));
    }
}

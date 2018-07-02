package three.sum;

import java.util.*;

public class Solution {

    /**
     * O(nlog(n))
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return ret;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int begin = i + 1;
            int end = len - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[begin]);
                    list.add(nums[end]);
                    ret.add(list);
                    begin ++;
                    end --;
                    while (begin < end && nums[begin] == nums[begin - 1]) {
                        begin ++;
                    }
                    while (begin < end && nums[end] == nums[end + 1]) {
                        end --;
                    }
                } else if (sum > 0) {
                    end--;
                } else {
                    begin ++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] test = new int[] {-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        System.out.println(solution.threeSum(test).toString());
    }
}

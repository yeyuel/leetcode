package recursive.combination.sum.one;

import java.util.*;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> item = new LinkedList<>();
        generate(0, candidates, result, item, 0, target);
        return result;
    }

    private void generate(int i,
                          int[] nums,
                          List<List<Integer>> result,
                          LinkedList<Integer> item,
                          int sum,
                          int target) {
        if (i >= nums.length || sum > target) {
             return;
        }
        for (int j = i; j < nums.length; j++) {
            sum += nums[j];
            item.add(nums[j]);
            if (target == sum) {
                result.add((LinkedList) item.clone());
            }
            generate(j, nums, result, item, sum, target);
            sum -= nums[j];
            item.pollLast();
        }
    }

    public static void main(String[] args) {
        int[] sample = new int[] {2, 3, 6, 7};
        int[] sample2 = new int[] {2, 3, 5};
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(sample, 7));
        System.out.println(solution.combinationSum(sample2, 8));
    }
}

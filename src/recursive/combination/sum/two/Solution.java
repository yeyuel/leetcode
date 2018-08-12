package recursive.combination.sum.two;

import java.util.*;

public class Solution {

    public  List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> item = new LinkedList<>();
        Set<List<Integer>> resSet = new HashSet<>();
        Arrays.sort(candidates);
        generate(0, candidates, result, item, resSet, 0, target);
        return result;
    }

    private void generate(int i,
                          int[] nums,
                          List<List<Integer>> result,
                          LinkedList<Integer> item,
                          Set<List<Integer>> resSet,
                          int sum,
                          int target) {
        if (i >= nums.length || sum > target) {
            return;
        }
        sum += nums[i];
        item.add(nums[i]);
        if (target == sum && !resSet.contains(item)) {
            LinkedList itemCopy = (LinkedList) item.clone();
            result.add(itemCopy);
            resSet.add(itemCopy);
        }
        generate(i + 1, nums, result, item, resSet, sum, target);
        sum -= nums[i];
        item.pollLast();
        generate(i + 1, nums, result, item, resSet, sum, target);
    }

    public static void main(String[] args) {
        int[] sample = new int[] {10, 1, 2, 7, 6, 1, 5};
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(sample, 8));
    }
}

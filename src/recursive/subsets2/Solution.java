package recursive.subsets2;

import java.util.*;

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> item = new LinkedList<>();
        Set<List<Integer>> resSet = new HashSet<>();
        Arrays.sort(nums);
        result.add(item);
        generate(0, nums, result, item, resSet);
        return result;
    }

    private void generate(int i,
                     int[] nums,
                     List<List<Integer>> result,
                     LinkedList<Integer> item,
                     Set<List<Integer>> resSet)
    {
        if (i >= nums.length) {
            return;
        }
        item.add(nums[i]);
        if (!resSet.contains(item)) {
            result.add((List<Integer>) item.clone());
            resSet.add(item);
        }
        generate(i + 1, nums, result, item, resSet);
        item.pollLast();
        generate(i + 1, nums, result, item, resSet);
    }

    public static void main(String[] args) {
        int[] sample = new int[] {2, 1, 2, 2};
        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(sample));
    }
}

package recursive.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> item = new LinkedList<>();
        result.add(item);
        generate(0, nums, item, result);
        return result;
    }

    public void generate(int i, int[] nums, LinkedList<Integer> item, List<List<Integer>> result) {
        if (i >= nums.length) {
            return;
        }
        item.add(nums[i]);
        result.add((LinkedList<Integer>) item.clone());
        generate(i + 1, nums, item, result);
        item.pollLast();
        generate(i + 1, nums, item,result);
    }


    public static void main(String[] args) {
        int[] sample = new int[] {1, 2, 3};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.subsets(sample));
    }
}

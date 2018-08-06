package recursive.subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int allSet = 1 << nums.length;
        for (int i = 0; i < allSet; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) > 0) {
                    item.add(nums[j]);
                }
            }
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] sample = new int[] {1, 2, 3};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.subsets(sample));
    }

}

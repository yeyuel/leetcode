package greedy.jump.game.two;

public class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int currentMaxIndex = nums[0];
        int preMaxIndex = nums[0];
        int jumpMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > currentMaxIndex) {
                jumpMin ++;
                currentMaxIndex = preMaxIndex;
            }
            if (preMaxIndex < i + nums[i]) {
                preMaxIndex = i + nums[i];
            }
        }
        return jumpMin;
    }

    public int jump1(int[] nums) {
        int pre = 0; // current coverage
        int cur = 0; // future coverage
        int jumpMin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > pre) {
                pre = cur;
                jumpMin ++;
            }
            cur = Math.max(cur, nums[i] + i);
        }
        return jumpMin;
    }

    public static void main(String[] args) {
        int[] sample = new int[] {2, 3, 1, 1, 4};
        Solution solution = new Solution();
        System.out.println(solution.jump(sample));
        System.out.println(solution.jump1(sample));
    }
}

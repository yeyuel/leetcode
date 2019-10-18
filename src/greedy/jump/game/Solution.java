package greedy.jump.game;

public class Solution {
    public boolean canJump(int[] nums) {
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i + nums[i];
        }
        int jump = 0;
        int maxIndex = nums[0];
        while (jump < index.length && jump <= maxIndex) {
            if (maxIndex < index[jump]) {
                maxIndex = index[jump];
            }
            jump ++;
        }
        if (jump == index.length) {
            return true;
        }
        return false;
    }

    public boolean canJump2(int[] nums)
    {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--)
        {
            if (nums[i] + i >= lastPos)
            {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        int[] sample1 = new int[] {2, 3, 1, 1, 4};
        int[] sample2 = new int[] {3, 2, 1, 0, 4};

        Solution solution = new Solution();
        System.out.println(solution.canJump(sample1));
        System.out.println(solution.canJump(sample2));
        System.out.println(solution.canJump2(sample1));
        System.out.println(solution.canJump2(sample2));
     }
}

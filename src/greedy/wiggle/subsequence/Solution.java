package greedy.wiggle.subsequence;

public class Solution {
    static final int BEGIN = 0;
    static final int UP = 1;
    static final int DOWN = 2;

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int state = BEGIN;
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            switch (state){
                case BEGIN:
                    if (nums[i - 1] < nums[i]) {
                        state = UP;
                        maxLength ++;
                    } else if (nums[i - 1] > nums[i]) {
                        state = DOWN;
                        maxLength ++;
                    }
                    break;
                case UP:
                    if (nums[i - 1] > nums[i]) {
                        state = DOWN;
                        maxLength ++;
                    }
                    break;
                case DOWN:
                    if (nums[i - 1] < nums[i]) {
                        state = UP;
                        maxLength ++;
                    }
                    break;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] sample1 = new int[] {1, 7, 4, 9, 2, 5};
        int[] sample2 = new int[] {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int[] sample3 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Solution solution = new Solution();
        System.out.println(solution.wiggleMaxLength(sample1));
        System.out.println(solution.wiggleMaxLength(sample2));
        System.out.println(solution.wiggleMaxLength(sample3));
    }
}

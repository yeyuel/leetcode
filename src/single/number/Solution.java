package single.number;

public class Solution {

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 2, 1};
        int[] nums2 = new int[]{4, 1, 2, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(nums1));
        System.out.println(solution.singleNumber(nums2));
    }
}

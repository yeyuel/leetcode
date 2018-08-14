package divide.conquer.search.insert.position;

public class Solution {

    public int searchInsert(int[] nums, int target) {
        int index = -1;
        int begin = 0;
        int end = nums.length - 1;
        while (index == -1) { // not same as common binary search
            int mid = (begin + end) / 2;
            if (target == nums[mid]) {
                index = mid;
            } else if (target < nums[mid]) {
                if (mid == 0 || target > nums[mid - 1]) {
                    index = mid;
                }
                end = mid - 1;
            } else if (target > nums[mid]) {
                if (mid == nums.length - 1 || target < nums[mid + 1]) {
                    index = mid + 1;
                }
                begin = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sample1 = new int[] {1,3,5,6};
        int[] sample2 = new int[] {1,3,5,6};
        int[] sample3 = new int[] {1,3,5,6};
        int[] sample4 = new int[] {1,3,5,6};
        System.out.println(solution.searchInsert(sample1, 5));
        System.out.println(solution.searchInsert(sample2, 2));
        System.out.println(solution.searchInsert(sample3, 7));
        System.out.println(solution.searchInsert(sample4, 0));
    }
}

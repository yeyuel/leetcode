package divide.conquer.search.rotated.sorted.array.two;

public class Solution {
    public boolean search(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                if (nums[begin] < nums[mid]) {
                    if (target > nums[begin]) {
                        end = mid - 1;
                    } else if (target < nums[begin]) {
                        begin = mid + 1;
                    } else {
                        return true;
                    }
                } else if (nums[begin] > nums[mid]) {
                    end = mid - 1;
                } else {
                    begin ++;
                }
            } else {
                if (nums[begin] < nums[mid]) {
                    begin = mid + 1;
                } else if (nums[begin] > nums[mid]) {
                    if (target > nums[begin]) {
                        end = mid - 1;
                    } else if (target < nums[begin]) {
                        begin = mid + 1;
                    } else {
                        return true;
                    }
                } else {
                    begin ++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.search(nums, 0));
        System.out.println(solution.search(nums, 3));
    }
}

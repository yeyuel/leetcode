package divide.conquer.search.rotated.sorted.array;

public class Solution {

    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) { // restricted to left part
                if (nums[begin] < nums[mid]) {
                    if (target >= nums[begin]) {
                        end = mid - 1;
                    } else {
                        begin = mid + 1;
                    }
                } else if (nums[begin] > nums[mid]) {
                    end = mid - 1;
                } else if (nums[begin] == nums[mid]) {
                    begin = mid + 1; // cautions
                }
            } else if (target > nums[mid]) { // restricted to right part
                if (nums[begin] < nums[mid]) {
                    begin = mid + 1;
                } else if (nums[begin] > nums[mid]) {
                    if (target >= nums[begin]) {
                        end = mid - 1;
                    } else {
                        begin = mid + 1;
                    }
                } else if (nums[begin] == nums[mid]) {
                    begin = mid + 1; // cautions
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sample = new int[] {4,5,6,7,0,1,2};
        System.out.println(solution.search(sample, 0));
        System.out.println(solution.search(sample, 3));
    }
}

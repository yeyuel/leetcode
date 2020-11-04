package find.duplicate;

public class Solution {

    public int findDuplicate1(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{1, 3, 4, 2, 2};
        int[] input2 = new int[]{3, 1, 3, 4, 2};

        Solution solution = new Solution();
        System.out.println(solution.findDuplicate1(input1));
        System.out.println(solution.findDuplicate1(input2));
        System.out.println(solution.findDuplicate(input1));
        System.out.println(solution.findDuplicate(input2));
    }
}

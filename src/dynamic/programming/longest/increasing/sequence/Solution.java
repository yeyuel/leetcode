package dynamic.programming.longest.increasing.sequence;

import java.util.LinkedList;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int lis = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (lis < dp[i]) {
                lis = dp[i];
            }
        }
        return lis;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > stack.peekLast()) {
                stack.add(nums[i]);
            } else {
                for (int j = 0; j < stack.size(); j++) {
                    if (stack.get(j) >= nums[i]) {
                        stack.set(j, nums[i]);
                        break;
                    }
                }
            }
        }
        return stack.size();
    }

    public int lengthOfLIS3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            if (target > stack.peekLast()) {
                stack.add(target);
            } else {
                int index = -1;
                int begin = 0;
                int end = stack.size() - 1;
                while (index == -1) {
                    int mid = (begin + end) / 2;
                    if (target == stack.get(mid)) {
                        index = mid;
                    } else if (target < stack.get(mid)) {
                        if (mid == 0 || target > stack.get(mid - 1)) {
                            index = mid;
                        }
                        end = mid - 1;
                    } else if (target > stack.get(mid)) {
                        if (mid == stack.size() - 1 || target < stack.get(mid + 1)) {
                            index = mid + 1;
                        }
                        begin = mid + 1;
                    }
                }
                stack.set(index, target);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sample = {10,9,2,5,3,7,101,18};
        System.out.println(solution.lengthOfLIS(sample));
        System.out.println(solution.lengthOfLIS2(sample));
        System.out.println(solution.lengthOfLIS3(sample));
    }
}

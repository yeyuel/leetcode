package reverse.integer;

import java.util.Stack;

public class Solution {

    public int reverse(int x) {
        boolean minus = false;
        if (x < 0) {
            minus = true;
            x = -x;
        }
        Stack<Integer> stack = new Stack<>();
        int highest = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            stack.push(digit);
            highest = digit;
        }
        int result = 0;
        int index = 0;
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            result += digit * Math.pow(10, index++);
        }
        int lowest = result % 10;
        if (minus) {
            result = - result;
        }
        if (lowest != highest) {
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int example1 = 123, example2 = -123, example3 = 120, example4 = 1534236469, example5 = -1563847412;
        Solution solution = new Solution();
        System.out.println(solution.reverse(example1));
        System.out.println(solution.reverse(example2));
        System.out.println(solution.reverse(example3));
        System.out.println(solution.reverse(example4));
        System.out.println(solution.reverse(example5));
    }
}

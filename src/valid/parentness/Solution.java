package valid.parentness;

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty()) {
                char peek = stack.peek();
                if (peek == '(' && ch == ')' || peek == '[' && ch == ']' || peek == '{' && ch == '}') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String sample1 = "()";
        String sample2 = "()[]{}";
        String sample3 = "(]";
        String sample4 = "([)]";
        String sample5 = "{[]}";
        Solution solution = new Solution();
        System.out.println(solution.isValid(sample1));
        System.out.println(solution.isValid(sample2));
        System.out.println(solution.isValid(sample3));
        System.out.println(solution.isValid(sample4));
        System.out.println(solution.isValid(sample5));
    }
}

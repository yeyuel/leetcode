package rails;

import java.util.Queue;
import java.util.Stack;

public class Solution {

    public boolean checkIsValidOrder(Queue<Integer> order) {
        Stack<Integer> stack = new Stack<>();
        int n = order.size();
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            while (!stack.empty() && order.peek() == stack.peek()) {
                stack.pop();
                order.poll();
            }
        }

        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}

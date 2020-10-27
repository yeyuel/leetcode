/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package eval.rpn;

import java.util.Stack;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/27$
 * @since 1.0
 */
public class Solution
{
    public int evalRPN(String[] tokens)
    {
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for (int i = 0; i < tokens.length; i++)
        {
            String s = tokens[i];
            if (s.equals("+"))
            {
                a = stack.pop();
                b = stack.pop();
                stack.push(b + a);
            }
            else if (s.equals("-"))
            {
                a = stack.pop();
                b = stack.pop();
                stack.push(b - a);
            }
            else if (s.equals("*"))
            {
                a = stack.pop();
                b = stack.pop();
                stack.push(b * a);
            }
            else if (s.equals("/"))
            {
                a = stack.pop();
                b = stack.pop();
                stack.push(b / a);
            }
            else
            {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        String[] input1 = new String[] { "2", "1", "+", "3", "*" };
        String[] input2 = new String[] { "4", "13", "5", "/", "+" };
        System.out.println(solution.evalRPN(input1));
        System.out.println(solution.evalRPN(input2));
    }
}

/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package calculate;

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
    public int calculate(String s)
    {
        return helper(new StringBuffer(s));
    }

    private int helper(StringBuffer sb)
    {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        while (sb.length() > 0)
        {
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            if (Character.isDigit(c))
            {
                num = 10 * num + (c - '0');
            }
            if (c == '(')
            {
                helper(sb);
            }
            if ((!Character.isDigit(c) && c != ' ') || sb.length() == 0)
            {
                switch (sign)
                {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    stack.push(stack.pop() * num);
                    break;
                case '/':
                    stack.push(stack.pop() / num);
                    break;
                }
                sign = c;
                num = 0;
            }
            if (c == ')')
                break;
        }
        int res = 0;
        while (!stack.empty())
        {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.calculate("3+2*2"));
        System.out.println(solution.calculate(" 3/2 "));
        System.out.println(solution.calculate(" 3+5 / 2 "));
    }
}

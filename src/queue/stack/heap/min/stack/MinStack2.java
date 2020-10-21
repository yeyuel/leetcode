/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package queue.stack.heap.min.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * MinStack2.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/21$
 * @since 1.0
 */
public class MinStack2
{
    private LinkedList<Integer> stack;
    private int minValue;

    public MinStack2()
    {
        stack = new LinkedList<>();
        minValue = -1;
    }

    public void push(int x)
    {
        if (stack.size() == 0)
        {
            stack.add(0);
            minValue = x;
        }
        else
        {
            int diff = x - this.minValue;
            stack.push(diff);
            minValue = diff > 0 ? minValue : x;
        }
    }

    public void pop()
    {
        if (!stack.isEmpty())
        {
            int diff = stack.pop();
            if (diff < 0)
            {
                minValue -= diff;
            }
        }
    }

    public int top()
    {
        return stack.peek() < 0 ? minValue : stack.peek() + minValue;
    }

    public int getMin()
    {
        return stack.isEmpty() ? -1 : minValue;
    }

    public static void main(String[] args)
    {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

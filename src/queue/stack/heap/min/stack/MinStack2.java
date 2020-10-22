/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package queue.stack.heap.min.stack;

import java.util.LinkedList;


/**
 * MinStack2.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/21$
 * @since 1.0
 */
public class MinStack2
{
    private LinkedList<Long> stack;
    private long minValue;

    public MinStack2()
    {
        stack = new LinkedList<>();
        minValue = -1;
    }

    public void push(int x)
    {
        if (stack.size() == 0)
        {
            stack.add(0L);
            minValue = x;
        }
        else
        {
            long diff = x - this.minValue;
            stack.push(diff);
            minValue = diff > 0 ? minValue : x;
        }
    }

    public void pop()
    {
        if (!stack.isEmpty())
        {
            long diff = stack.pop();
            if (diff < 0)
            {
                minValue -= diff;
            }
        }
    }

    public int top()
    {
        return stack.peek() < 0 ? (int) minValue : (int) (stack.peek() + minValue);
    }

    public int getMin()
    {
        return stack.isEmpty() ? -1 : (int) minValue;
    }

    public static void main(String[] args)
    {
        MinStack2 minStack = new MinStack2();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        minStack.pop();
        minStack.push(-2147483648);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

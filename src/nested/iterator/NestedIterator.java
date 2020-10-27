/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package nested.iterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/27$
 * @since 1.0
 */
public class NestedIterator implements Iterator<Integer>
{
    Deque<NestedInteger> stack = new ArrayDeque<>();


    public NestedIterator(List<NestedInteger> nestedList)
    {
        for (int i = nestedList.size(); i >= 0; i--)
        {
            stack.offerFirst(nestedList.get(i));
        }
    }

    @Override
    public boolean hasNext()
    {
        if (stack.isEmpty())
        {
            return false;
        }
        else
        {
            if (!stack.peekFirst().isInteger())
            {
                List<NestedInteger> ni = stack.pollFirst().getList();
                for (int i = ni.size() - 1; i >= 0; --i)
                {
                    stack.offerFirst(ni.get(i));
                }
                return hasNext();
            }
            else
            {
                return true;
            }
        }
    }

    @Override
    public Integer next()
    {
        return stack.pollFirst().getInteger();
    }
}

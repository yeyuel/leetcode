/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package nested.iterator;

import java.util.List;


/**
 * NestedInteger.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/27$
 * @since 1.0
 */
public interface NestedInteger
{
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}

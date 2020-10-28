/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package randomized.set;

import java.util.*;


/**
 * RandomizedSet.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/28$
 * @since 1.0
 */
public class RandomizedSet
{
    Map<Integer, Integer> dict;
    List<Integer> list;
    Random rand = new Random();

    public RandomizedSet()
    {
        dict = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val)
    {
        if (dict.containsKey(val)) return false;
        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val)
    {
        if (!dict.containsKey(val)) return false;
        int lastElement = list.get(list.size() - 1);
        int idx = dict.get(val);
        list.set(idx, lastElement);
        dict.put(lastElement, idx);
        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }

    public int getRandom()
    {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args)
    {
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
    }
}

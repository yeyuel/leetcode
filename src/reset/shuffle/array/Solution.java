/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package reset.shuffle.array;

import java.util.Arrays;
import java.util.Random;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/13$
 * @since 1.0
 */
public class Solution
{
    private int[] array;
    private int[] original;

    Random rand = new Random();

    public Solution(int[] nums)
    {
        this.array = nums;
        this.original = nums.clone();
    }

    public int[] reset()
    {
        this.array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle()
    {
        for (int i = 0; i < array.length; i++)
        {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    private int randRange(int min, int max)
    {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j)
    {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 3 };
        Solution solution = new Solution(nums);
        int[] shuffled = solution.shuffle();
        System.out.println(Arrays.toString(shuffled));
        final int[] reset = solution.reset();
        System.out.println(Arrays.toString(reset));
        shuffled = solution.shuffle();
        System.out.println(Arrays.toString(shuffled));
    }
}

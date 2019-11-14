/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package is.valid.suduku;

import java.util.HashMap;
import java.util.Map;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/11/14$
 * @since 1.0
 */
public class Solution
{
    public boolean isValidSudoku(char[][] borad)
    {
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] colums = new HashMap[9];
        Map<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++)
        {
            rows[i] = new HashMap<>();
            colums[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                char num = borad[i][j];
                if (num != '.')
                {
                    int n = (int) num;
                    int boxIndex = (i / 3) * 3 + j / 3;
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    colums[j].put(n, colums[j].getOrDefault(n, 0) + 1);
                    boxes[boxIndex]
                            .put(n, boxes[boxIndex].getOrDefault(n, 0) + 1);

                    if (rows[i].get(n) > 1 || colums[j].get(n) > 1
                            || boxes[boxIndex].get(n) > 1)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        char[][] sample1 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        char[][] sample2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution.isValidSudoku(sample1));
        System.out.println(solution.isValidSudoku(sample2));
    }
}

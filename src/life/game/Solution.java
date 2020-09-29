/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package life.game;

import java.util.Arrays;


/**
 * Solution. 289
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/9/28$
 * @since 1.0
 */
public class Solution
{
    public void gameOfLife(int[][] board)
    {
        int[] neighbors = { 0, 1, -1 };
        int rows = board.length, cols = board[0].length;

        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                int liveNeighbors = 0;
                for (int i = 0; i < 3; i++)
                {
                    for (int j = 0; j < 3; j++)
                    {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0))
                        {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);
                            if ((r < rows && r >= 0) && (c < cols && c >= 0)
                                    && (Math.abs(board[r][c]) == 1))
                            {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // rule 1 & 3
                if ((board[row][col] == 1) && (liveNeighbors < 2
                        || liveNeighbors > 3))
                {
                    board[row][col] = -1;
                }

                // rule 4
                if (board[row][col] == 0 && liveNeighbors == 3)
                {
                    board[row][col] = 2;
                }
            }
        }

        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                if (board[row][col] > 0)
                {
                    board[row][col] = 1;
                }
                else
                {
                    board[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] input = new int[][]{{0,1,0},
                                    {0,0,1},
                                    {1,1,1},
                                    {0,0,0}};
        Solution solution = new Solution();
        solution.gameOfLife(input);
        System.out.println(Arrays.deepToString(input));
    }
}

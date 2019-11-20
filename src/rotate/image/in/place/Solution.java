/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package rotate.image.in.place;

import java.util.Arrays;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/11/20$
 * @since 1.0
 */
public class Solution
{
    public void rotate(int[][] matrix)
    {
        int n = matrix.length;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        int[][] matrix2 = {
                { 7, 4, 1 },
                { 8, 5, 2 },
                { 9, 6, 3 } };
        Solution solution = new Solution();
        solution.rotate(matrix1);
        solution.rotate(matrix2);
        System.out.println(Arrays.toString(matrix1));
        System.out.println(Arrays.toString(matrix2));
    }
}

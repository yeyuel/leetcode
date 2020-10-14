/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package search.matrix.two;

/**
 * Solution. 240
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/14$
 * @since 1.0
 */
public class Solution
{
    public boolean searchMatrix1(int[][] matrix, int target)
    {
        if (matrix == null || matrix.length == 0)
        {
            return false;
        }
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++)
        {
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound)
            {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start,
            boolean vertical)
    {
        int lo = start;
        int hi = vertical ? matrix[0].length - 1 : matrix.length - 1;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (vertical) // search a column
            {
                if (matrix[start][mid] < target)
                {
                    lo = mid + 1;
                }
                else if (matrix[start][mid] > target)
                {
                    hi = mid - 1;
                }
                else
                {
                    return true;
                }
            }
            else // search a row
            {
                if (matrix[mid][start] < target)
                {
                    lo = mid + 1;
                }
                else if (matrix[mid][start] > target)
                {
                    hi = mid - 1;
                }
                else
                {
                    return true;
                }
            }
        }
        return false;
    }

    private int[][] matrix;
    private int target;

    private boolean searchRec(int left, int up, int right, int down)
    {
        if (left > right || up > down)
        {
            return false;
        }
        else if (target < matrix[up][left] || target > matrix[down][right])
        {
            return false;
        }
        int mid = left + (right - left) / 2;

        int row = up;
        while (row <= down && matrix[row][mid] <= target)
        {
            if (matrix[row][mid] == target)
            {
                return true;
            }
            row++;
        }
        return searchRec(left, row, mid - 1, down) || searchRec(mid + 1, up,
                right, row - 1);
    }

    public boolean searchMatrix2(int[][] matrix, int target)
    {
        this.matrix = matrix;
        this.target = target;
        if (matrix == null || matrix.length == 0)
        {
            return false;
        }
        return searchRec(0, 0, matrix[0].length - 1, matrix.length - 1);
    }

    public boolean searchMatrix3(int[][] matrix, int target)
    {
        int row = matrix.length - 1;
        int col = 0;

        while (row > 0 && col < matrix[0].length)
        {
            if (matrix[row][col] > target)
            {
                row--;
            }
            else if (matrix[row][col] < target)
            {
                col++;
            }
            else
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[][] matrix = new int[][] {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix1(matrix, 5));
        System.out.println(solution.searchMatrix1(matrix, 20));
        System.out.println(solution.searchMatrix2(matrix, 5));
        System.out.println(solution.searchMatrix2(matrix, 20));
        System.out.println(solution.searchMatrix3(matrix, 5));
        System.out.println(solution.searchMatrix3(matrix, 20));

    }
}

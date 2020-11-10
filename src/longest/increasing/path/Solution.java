package longest.increasing.path;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] outDegrees = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int[] dir : dirs) {
                    int newRow = i + dir[0], newColumn = j + dir[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns
                            && matrix[newRow][newColumn] > matrix[i][j]) {
                        ++outDegrees[i][j];
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (outDegrees[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            ++ans;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], column = cell[1];
                for (int[] dir : dirs) {
                    int newRow = row + dir[0], newColumn = column + dir[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns
                            && matrix[newRow][newColumn] < matrix[row][column]) {
                        --outDegrees[newRow][newColumn];
                        if (outDegrees[newRow][newColumn] == 0) {
                            queue.offer(new int[]{newRow, newColumn});
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums1 = new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        int[][] nums2 = new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        Solution solution = new Solution();
        System.out.println(solution.longestIncreasingPath(nums1));
        System.out.println(solution.longestIncreasingPath(nums2));
    }
}

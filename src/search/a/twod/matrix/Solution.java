package search.a.twod.matrix;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int colLength = matrix[0].length;
        int left = 0;
        int right = colLength * matrix.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            int row = mid / colLength;
            int col = mid % colLength;

            if (target == matrix[row][col]) {
                index = mid;
                break;
            } else if (target > matrix[row][col]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index != -1;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = searchRowIndex(matrix, target);
        return searchCol(matrix, row, target);
    }

    private int searchRowIndex(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (matrix[mid][0] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean searchCol(int[][] matrix, int row, int target) {
        int[] data = matrix[row];
        int left = 0, right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                return true;
            } else if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(solution.searchMatrix(matrix, 3));
        System.out.println(solution.searchMatrix(matrix, 13));
        System.out.println(solution.searchMatrix1(matrix, 3));
        System.out.println(solution.searchMatrix1(matrix, 13));
    }
}

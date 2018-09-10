package breadth.first.search.number.of.islands;

import java.util.LinkedList;

public class Solution {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int islandNum = 0;
        char [][] mark = new char [grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (mark[i][j] == 0 && grid[i][j] == '1') {
//                    dfs(mark, grid, i, j);
                    bfs(mark, grid, i, j);
                    islandNum ++;
                }
            }
        }
        return islandNum;
    }

    private void dfs(char [][] mark, char[][] grid, int x, int y) {
        mark[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = dx[i] + x;
            int newY = dy[i] + y;
            if (newX < 0 || newX >= mark.length ||
                    newY < 0 || newY >= mark[newX].length) {
                continue;
            }
            if (mark[newX][newY] == 0 && grid[newX][newY] == '1') {
                dfs(mark, grid, newX, newY);
            }
        }
    }

    private void bfs(char[][] mark, char[][] grid, int x, int y) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        mark[x][y] = 1;
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            x = head[0];
            y = head[1];
            for (int i = 0; i < 4; i++) {
                int newX = dx[i] + x;
                int newY = dy[i] + y;
                if (newX < 0 || newX >= mark.length ||
                        newY < 0 || newY >= mark[newX].length) {
                    continue;
                }
                if (mark[newX][newY] == 0 && grid[newX][newY] == '1') {
                    queue.push(new int[]{newX, newY});
                    mark[newX][newY] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] sample1 = {{'1', '1', '1', '1', '0'},
                            {'1', '1', '0', '1', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '0', '0', '0'}};
        char[][] sample2 = {{'1', '1', '0', '0', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '1', '0', '0'},
                            {'0', '0', '0', '1', '1'}};
        Solution solution = new Solution();
        System.out.println(solution.numIslands(sample1));
        System.out.println(solution.numIslands(sample2));
    }
}

package breadth.first.search.knight.move;

import java.util.LinkedList;

public class Solution {

    private static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    class Location {
        int x;
        int y;
        int step;

        public Location(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }


    private int bfsMove(int beginX, int beginY, int endX, int endY, int n) {
        int[][] mark = new int[n][n];
        LinkedList<Location> queue = new LinkedList<>();
        queue.add(new Location(beginX, beginY, 0));
        mark[beginX][beginY] = 1;
        while (!queue.isEmpty()) {
            Location head = queue.poll();
            if (head.x == endX && head.y == endY) {
                return head.step;
            }
            for (int i = 0; i < 8; i++) {
                int newX = dx[i] + head.x;
                int newY = dy[i] + head.y;
                if (newX < 0 || newX >= n ||
                        newY < 0 || newY >= n ||
                        mark[newX][newY] != 0) {
                    continue;
                }
                queue.add(new Location(newX, newY, head.step + 1));
                mark[newX][newY] = 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bfsMove(0, 0, 1, 2, 10));
    }
}

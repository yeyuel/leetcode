package breadth.first.search.trapping.water.two;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    static final int dx[] = {-1, 1, 0, 0};
    static final int dy[] = {0, 0, -1, 1};

    class QItem {
        int x;
        int y;
        int h;

        public QItem(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        Comparator<QItem> qItemComparator = new Comparator<QItem>() {
            @Override
            public int compare(QItem o1, QItem o2) {
                return o1.h - o2.h;
            }
        };
        PriorityQueue<QItem> priorityQueue = new PriorityQueue<>(qItemComparator);
        if (heightMap.length < 3 || heightMap[0].length < 3) {
            return 0;
        }
        int row = heightMap.length;
        int column = heightMap[0].length;

        // mark matrix
        int[][] mark = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mark[i][j] = 0;
            }
        }

        for (int i = 0; i < row; i++) {
            priorityQueue.add(new QItem(i, 0, heightMap[i][0]));
            mark[i][0] = 1;
            priorityQueue.add(new QItem(i, column - 1, heightMap[i][column - 1]));
            mark[i][column - 1] = 1;
        }

        for (int i = 1; i < column - 1; i++) {
            priorityQueue.add(new QItem(0, i, heightMap[0][i]));
            mark[0][i] = 1;
            priorityQueue.add(new QItem(row - 1, i, heightMap[row - 1][i]));
            mark[row - 1][i] = 1;
        }

        int result = 0;
        while (!priorityQueue.isEmpty()) {
            QItem current = priorityQueue.poll();
            int x = current.x;
            int y = current.y;
            int h = current.h;
            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];
                if (newx < 0 || newx >= row ||
                        newy < 0 || newy >= column ||
                        mark[newx][newy] == 1) {
                    continue;
                }
                if (h > heightMap[newx][newy]) {
                    result += h - heightMap[newx][newy];
                    heightMap[newx][newy] = h;
                }
                priorityQueue.add(new QItem(newx, newy, heightMap[newx][newy]));
                mark[newx][newy] = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] sample = {{1, 4, 3, 1, 3, 2},
                          {3, 2, 1, 3, 2, 4},
                          {2, 3, 3, 2, 3, 1}};
        Solution solution = new Solution();
        System.out.println(solution.trapRainWater(sample));
    }
}

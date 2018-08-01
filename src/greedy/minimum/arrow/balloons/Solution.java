package greedy.minimum.arrow.balloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(points, comparator);
        int shootNum = 1;
//        int shootBegin = points[0][0];
        int shootEnd = points[0][1];

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] <= shootEnd) {
//                shootBegin = points[i][0];
                if (points[i][1] < shootEnd) {
                    shootEnd = points[i][1];
                }
            } else {
                shootNum ++;
//                shootBegin = points[i][0];
                shootEnd = points[i][1];
            }
        }
        return shootNum;
    }

    public static void main(String[] args) {
        int[][] sample = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(sample));
    }
}

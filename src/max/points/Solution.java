package max.points;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private int[][] points;
    int n;
    Map<String, Integer> lines = new HashMap<>();
    int horisontalLines;

    public int[] add_line(int i, int j, int count, int duplicates) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];

        if ((x1 == x2) && (y1 == y2)) {
            duplicates++;
        } else if (y1 == y2) {
            horisontalLines++;
            count = Math.max(horisontalLines, count);
        } else {
            String slope =slope(x1 - x2, y1 - y2);
            lines.put(slope, lines.getOrDefault(slope, 1) + 1);
            count = Math.max(lines.get(slope), count);
        }
        return new int[]{count, duplicates};
    }

    public int maxPointsOnALineContainingPointI(int i) {
        lines.clear();
        horisontalLines = 1;
        int count = 1;
        int duplicates = 0;
        for (int j = i + 1; j < n; j++) {
            int[] p = add_line(i, j, count, duplicates);
            count = p[0];
            duplicates = p[1];
        }
        return count + duplicates;
    }


    public int maxPoints(int[][] points) {
        this.points = points;
        n = points.length;
        if (n < 3) {
            return n;
        }
        int maxCount = 1;
        for (int i = 0; i < n - 1; i++) {
            maxCount = Math.max(maxPointsOnALineContainingPointI(i), maxCount);
        }
        return maxCount;
    }

    private String slope(int p, int q) {
        int gcd = gcd(p, q);
        return p / gcd + "_" + q / gcd;
    }

    private int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points1 = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        int[][] points2 = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(solution.maxPoints(points1));
        System.out.println(solution.maxPoints(points2));
    }
}

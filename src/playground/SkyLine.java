package playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkyLine {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int len = buildings.length;
        if (len == 0) return new ArrayList<>();
        return segment(buildings, 0, len - 1);
    }

    private List<List<Integer>> segment(int[][] buildings, int l, int r) {
        List<List<Integer>> res = new ArrayList<>();
        if (l == r) {
            res.add(Arrays.asList(buildings[l][0], buildings[l][2]));
            res.add(Arrays.asList(buildings[l][1], 0));
            return res;
        }

        int mid = l + (r - l) / 2;
        List<List<Integer>> left = segment(buildings, l, mid);
        List<List<Integer>> right = segment(buildings, mid + 1, r);

        int m = 0, n = 0;
        int lpreH = 0, rpreH = 0;
        int leftX, leftY, rightX, rightY;
        while (m < left.size() || n < right.size()) {
            if (m >= left.size()) res.add(right.get(n++));
            else if (n >= right.size()) res.add(left.get(m++));
            else {
                leftX = left.get(m).get(0);
                leftY = left.get(m).get(1);
                rightX = right.get(n).get(0);
                rightY = right.get(n).get(1);
                if (leftX < rightX) {
                    if (leftY > rpreH) res.add(left.get(m));
                    else if (lpreH > rpreH) res.add(Arrays.asList(leftX, rpreH));
                    lpreH = leftY;
                    m++;
                } else if (leftX > rightX) {
                    if (rightY > lpreH) res.add(right.get(n));
                    else if (rpreH > lpreH) res.add(Arrays.asList(rightX, lpreH));
                    rpreH = rightY;
                    n++;
                } else {
                    if (leftY >= rightY && leftY != (Math.max(lpreH, rpreH))) res.add(left.get(m));
                    else if (leftY <= rightY && rightY != (Math.max(lpreH, rpreH))) res.add(right.get(n));
                    lpreH = leftY;
                    rpreH = rightY;
                    m++;
                    n++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] buildings = new int[][] {{0, 2, 3}, {2, 5, 3}};
        System.out.println(new SkyLine().getSkyline(buildings));
    }
}

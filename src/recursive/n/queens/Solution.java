package recursive.n.queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private static final int[] dx = new int[] {-1, 1, 0, 0, -1, -1, 1, 1};
    private static final int[] dy = new int[] {0, 0, -1, 1, -1, 1, -1, 1};

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] mark = new int[n][n];
        ArrayList<String> location = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            location.add(sb.toString());
        }
        generate(0, n, location, result, mark);
        return result;
    }

    private void generate(int k,
                          int n,
                          ArrayList<String> location,
                          List<List<String>> result,
                          int[][] mark) {
        if (k == n) {
            result.add((ArrayList) location.clone());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (mark[k][i] == 0) {
                int[][] tmpMark = new int[mark.length][mark[0].length];
                for (int j = 0; j < mark.length; j++) {
                    tmpMark[j] = Arrays.copyOf(mark[j], mark[j].length);
                }
                StringBuffer sb  = new StringBuffer(location.get(k));
                location.set(k, sb.replace(i, i + 1, "Q").toString());
                putDownTheQueen(k, i, mark);
                generate(k + 1, n, location, result, mark);
                mark = tmpMark;
                sb  = new StringBuffer(location.get(k));
                location.set(k, sb.replace(i, i + 1, ".").toString());
            }
        }
    }

    private void putDownTheQueen(int x, int y,
                                 int[][] mark) {
        mark[x][y] = 1;
        for (int i = 0; i < mark.length; i++) {
            for (int j = 0; j < 8; j++) {
                int newX = x + i * dx[j];
                int newY = y + i * dy[j];
                if (newX >= 0 && newX < mark.length
                        && newY >= 0 && newY < mark.length) {
                    mark[newX][newY] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }
}

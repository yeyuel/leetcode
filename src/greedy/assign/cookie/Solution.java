package greedy.assign.cookie;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                child ++;
            }
            cookie ++;
        }
        return child;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] g1 = new int[] {1, 2, 3};
        int[] s1 = new int[] {1, 1};

        int[] g2 = new int[] {1, 2};
        int[] s2 = new int[] {1, 2, 3};

        int[] g3 = new int[] {10, 9, 8, 7};
        int[] s3 = new int[] {5, 6, 7, 8};

        System.out.println(solution.findContentChildren(g1, s1));
        System.out.println(solution.findContentChildren(g2, s2));
        System.out.println(solution.findContentChildren(g3, s3));
    }
}

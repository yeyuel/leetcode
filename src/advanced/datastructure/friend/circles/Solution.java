package advanced.datastructure.friend.circles;

public class Solution {

    class DisjointSet {
        private int[] ids;
        private int[] sizes;
        int count;

        public DisjointSet(int n) {
            ids = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                ids[i] = i;
                sizes[i] = 1;
            }
            this.count = n;
        }

        int find(int p) {
            while (p != ids[p]) {
//                ids[p] = ids[ids[p]];
                p = ids[p];
            }
            return p;
        }

        void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) {
                return;
            }
            if (sizes[i] < sizes[j]) {
                ids[i] = j;
                sizes[i] += sizes[j];
            } else {
                ids[j] = i;
                sizes[j] += sizes[i];
            }
            count--;
        }
    }

    public int findCircleNum(int[][] M) {
        int[] visit = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visit[i] == 0) {
                dfsGraph(i, visit, M);
                count ++;
            }
        }
        return count;
    }

    public int findCircleNum2(int[][] M) {
        DisjointSet disjointSet = new DisjointSet(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    disjointSet.union(i, j);
                }
            }
        }
        return disjointSet.count;
    }

    private void dfsGraph(int u, int[] visit, int[][] graph) {
        visit[u] = 1;
        for (int i = 0; i < graph[u].length; i++) {
            if (visit[i] == 0 && graph[u][i] == 1) {
                dfsGraph(i, visit, graph);
            }
        }
    }

    public static void main(String[] args) {
        int[][] sample1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] sample2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        Solution solution = new Solution();
        System.out.println(solution.findCircleNum(sample1));
        System.out.println(solution.findCircleNum(sample2));
        System.out.println(solution.findCircleNum2(sample1));
        System.out.println(solution.findCircleNum2(sample2));
    }
}

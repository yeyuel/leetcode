package playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopologicalOrder {

    List<List<Integer>> edges;
    int[] visited;
    int[] result;
    int index;


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        boolean valid = true;
        for (int i = 0; i < numCourses; ++i) {
            if (visited[i] == 0) {
                valid = dfs(i);
                if (!valid) break;
            }
        }
        if (!valid) {
            return new int[0];
        }
        return result;
    }


    public boolean dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                if (!dfs(v)) {
                    return false;
                }
            } else if (visited[v] == 1) {
                return false;
            }
        }
        visited[u] = 2;
        result[index--] = u;
        return true;
    }

    public static void main(String[] args) {
        int[][] inputs = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        TopologicalOrder solution = new TopologicalOrder();
        System.out.println(Arrays.toString(solution.findOrder(4, inputs)));
    }
}

package graph.course.schedule;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    class GraphNode {
        int label;
        List<GraphNode> neighbors = new ArrayList<>();
        GraphNode(int x) {
            this.label = x;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<GraphNode> graphNodeList = new ArrayList<>();
        int[] visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graphNodeList.add(new GraphNode(i));
            visit[i] = -1;
        }
        for (int i = 0; i < prerequisites.length; i++) {
            GraphNode begin = graphNodeList.get(prerequisites[i][1]);
            GraphNode end = graphNodeList.get(prerequisites[i][0]);
            begin.neighbors.add(end);
        }
        for (int i = 0; i < graphNodeList.size(); i++) {
            if (visit[i] == -1 && !dfsGraph(graphNodeList.get(i), visit)) {
                return false;
            }
        }
        return true;
    }

    boolean dfsGraph(GraphNode node, int[] visit) {
        visit[node.label] = 0;
        List<GraphNode> neighbors = node.neighbors;
        for (int i = 0; i < neighbors.size(); i++) {
            GraphNode adjacent = neighbors.get(i);
            if (visit[adjacent.label] == -1) {
                if (!dfsGraph(adjacent, visit)) {
                    return false;
                }
            } else if (visit[adjacent.label] == 0) {
                return false;
            }
        }
        visit[node.label] = 1;
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[][] sample1 = {{1, 0}};
        int[][] sample2 = {{1, 0}, {0, 1}};
        System.out.println(solution1.canFinish(2, sample1));
        System.out.println(solution1.canFinish(2, sample2));
    }
}

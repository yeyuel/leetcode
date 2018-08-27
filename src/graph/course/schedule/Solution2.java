package graph.course.schedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {

    class GraphNode {
        int label;
        List<GraphNode> neighbors = new ArrayList<>();
        GraphNode(int label) {
            this.label = label;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<GraphNode> graph = new ArrayList<>();
        int[] degree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new GraphNode(i));
        }
        for (int i = 0; i < prerequisites.length; i++) {
            GraphNode begin = graph.get(prerequisites[i][1]);
            GraphNode end = graph.get(prerequisites[i][0]);
            begin.neighbors.add(end);
            degree[prerequisites[i][0]] ++;
        }
        LinkedList<GraphNode> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(graph.get(i));
            }
        }
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            List<GraphNode> neighbors = node.neighbors;
            for (int i = 0; i < neighbors.size(); i++) {
                degree[neighbors.get(i).label] --;
                if (degree[neighbors.get(i).label] == 0) {
                    queue.add(neighbors.get(i));
                }
            }
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[][] sample1 = {{1, 0}};
        int[][] sample2 = {{1, 0}, {0, 1}};
        System.out.println(solution2.canFinish(2, sample1));
        System.out.println(solution2.canFinish(2, sample2));
    }
}

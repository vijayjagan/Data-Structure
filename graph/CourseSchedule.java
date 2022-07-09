package graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    //     0 - not visited
    //     1 - visited
    //     2 - in the DFS Call

    static boolean isCycleDirected(int node, int[] visited, List<List<Integer>> adjList) {
        visited[node] = 2;

        for (Integer courses : adjList.get(node)) {
            if (visited[courses] == 0) {
                if (isCycleDirected(courses, visited, adjList)) {
                    return true;
                }
            } else if (visited[courses] == 2) {
                return true;
            }
        }
        visited[node] = 1;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];

        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && isCycleDirected(i, visited, adjList) ) {
                return false;
            }
        }
        return true;
    }
}

package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class LeetCode_210 {

  static boolean traceCourseOrder(int vertex, int[] visited, List<List<Integer>> adj,
      List<Integer> courseOrder) {
    visited[vertex] = 1;
    courseOrder.add(vertex);
    for (int node : adj.get(vertex)) {
      if (visited[node] == 0) {
        if (traceCourseOrder(node, visited, adj, courseOrder)) {
          return true;
        }
      } else if (visited[node] == 1) {
        return true;
      }
    }
    visited[vertex] = 2;
    return false;
  }

  public static int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adj.add(i, new ArrayList<>());
    }
    for (int[] course : prerequisites) {
      adj.get(course[0]).add(course[1]);
    }
    System.out.println(adj);
    int[] visited = new int[numCourses];
    List<Integer> courseOrder = new ArrayList<>();
    for (int i = 0; i < adj.size(); i++) {
      if (visited[i] == 0 && traceCourseOrder(i, visited, adj, courseOrder)) {
        return new int[0];
      }
    }
    return courseOrder.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    int[][] prerequisites = new int[][]{
        {0, 1}
    };
    System.out.println(Arrays.toString(findOrder(2, prerequisites)));
  }


}

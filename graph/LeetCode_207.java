package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode_207 {


  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adj.add(i, new ArrayList<>());
    }
    for (int[] course : prerequisites) {
      adj.get(course[0]).add(course[1]);
    }
    int[] inDegreeCount = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      for (int vertex : adj.get(i)) {
        inDegreeCount[vertex]++;
      }
    }
    Queue<Integer> bfs = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegreeCount[i] == 0) {
        bfs.add(i);
      }
    }
    List<Integer> topoSort = new ArrayList<>();
    while (!bfs.isEmpty()) {
      int vertex = bfs.poll();
      topoSort.add(vertex);
      for (int node : adj.get(vertex)) {
        inDegreeCount[node] --;
        if (inDegreeCount[node] == 0) {
          bfs.add(node);
        }
      }
    }
    return topoSort.size() == numCourses;
  }

}

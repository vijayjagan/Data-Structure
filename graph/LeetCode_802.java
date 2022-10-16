package graph;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_802 {

  // 0 - unvisited
  // 1 - InStack
  // 2 - Leads to cyclicNode
  // 3 - done visiting

  static boolean findEventualSafeNode(int vertex, int[] visited, int[][] graph) {
    visited[vertex] = 1;
    for (Integer adjacency : graph[vertex]) {
      if (visited[adjacency] == 0) {
        if (findEventualSafeNode(adjacency, visited, graph)) {
          visited[adjacency] = 2;
          return true;
        }
      } else if (visited[adjacency] == 1 || visited[adjacency] == 2) {
        return true;
      }
    }
    visited[vertex] = 3;
    return false;
  }

  public static List<Integer> eventualSafeNodes(int[][] graph) {
    int[] visited = new int[graph.length];
    List<Integer> eventualNodes = new ArrayList<>();

    for (int i = 0; i < graph.length; i++) {
      if (visited[i] == 0) {
        findEventualSafeNode(i, visited, graph);
      }
      if (visited[i] == 3) {
        eventualNodes.add(i);
      }
    }
    return eventualNodes;
  }

  public static void main(String[] args) {
    int[][] graph = new int[][]{
        {0,1,4},
        {0,2},
        {3,4},
        {2,4},
        {3}
    };
    System.out.println(eventualSafeNodes(graph));
  }

}

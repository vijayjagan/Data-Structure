package graph.cycle.directed;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {

  // 0 - unvisited
  // 1 - InStack
  // 2 - done visiting
  static boolean isCycle(int vertex, int[] visited, ArrayList<ArrayList<Integer>> adj) {
    visited[vertex] = 1;
    for (int adjacency : adj.get(vertex)) {
      if (visited[adjacency] == 0) {
        if (isCycle(adjacency, visited, adj)) {
          return true;
        }
      } else if (visited[adjacency] == 1) {
        return true;
      }
    }
    visited[vertex] = 2;
    return false;
  }

  public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    int[] visited = new int[V];
    for (int i = 0; i < V; i++) {
      if (visited[i] == 0 && isCycle(i, visited, adj)) {
        return true;
      }
    }
    return false;
  }

}

package graph.cycle.undirected;

import java.util.ArrayList;

public class DFS {


  boolean checkForCycleViaDFS(int parent, int vertex, ArrayList<ArrayList<Integer>> adj,
      int[] visited) {

    for (int adjacency : adj.get(vertex)) {
      if (visited[adjacency] == 0) {
        visited[adjacency] = 1;
        if (checkForCycleViaDFS(vertex, adjacency, adj, visited)) {
          return true;
        }
      } else if (parent != adjacency) {
        return true;
      }
    }
    return false;
  }

  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    int[] visited = new int[V];

    for (int i = 0; i < V; i++) {
      if (visited[i] == 0) {
        visited[i] = 1;
        if (checkForCycleViaDFS(-1, i, adj, visited)) {
          return true;
        }
      }
    }
    return false;
  }

}

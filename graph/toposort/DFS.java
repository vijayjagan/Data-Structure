package graph.toposort;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {

  static void updateStack(int vertex, int[] visited, Stack<Integer> topoSort,
      ArrayList<ArrayList<Integer>> adj) {

    visited[vertex] = 1;
    for (Integer adjacency : adj.get(vertex)) {
      if (visited[adjacency] == 0) {
        updateStack(adjacency, visited, topoSort, adj);
      }
    }
    topoSort.push(vertex);
  }

  static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    int [] visited = new int[V];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < V; i++) {
      if (visited[i] == 0) {
        updateStack(i, visited, stack, adj);
      }
    }
    int [] topoSort = new int[V];
    for (int i = 0; i < V; i++) {
      topoSort[i] = stack.pop();
    }
    return topoSort;
  }

}

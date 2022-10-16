package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Bipartite {

  static boolean colorUsingBFS(int vertex, int[] color, ArrayList<ArrayList<Integer>> adj) {
    Queue<Integer> bfs = new ArrayDeque<>();
    color[vertex] = 1;
    bfs.add(vertex);

    while (!bfs.isEmpty()) {
      int neighbour = bfs.poll();
      for (Integer adjacency : adj.get(neighbour)) {
        if (color[adjacency] == -1) {
          color[adjacency] = 1 - color[neighbour];
          bfs.add(adjacency);
        } else if (color[adjacency] == color[neighbour]) {
          return false;
        }
      }
    }
    return true;
  }

  static boolean colorUsingDFS(int vertex, int[] color, ArrayList<ArrayList<Integer>> adj) {
    for (Integer adjacency : adj.get(vertex)) {
      if (color[adjacency] == -1) {
        color[adjacency] = 1 - color[vertex];
        if (!colorUsingDFS(adjacency, color, adj)) {
          return false;
        }
      } else if (color[adjacency] == color[vertex]) {
        return false;
      }
    }
    return true;
  }

  public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
    int[] color = new int[V];
    Arrays.fill(color, -1);

    for (int i = 0; i < V; i++) {
      if (color[i] == -1) {
        color[i] = 0;
        if (!colorUsingDFS(i, color, adj)) {
          return false;
        }
      }
    }
    return true;
  }

}

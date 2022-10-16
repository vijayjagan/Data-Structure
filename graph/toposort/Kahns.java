package graph.toposort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Kahns {

  static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    int[] inDegreeCount = new int[V];
    int[] topoSort = new int[V];
    Queue<Integer> bfs = new ArrayDeque<>();

    for (int i = 0; i < V; i++) {
      for (int vertex : adj.get(i)) {
        inDegreeCount[vertex]++;
      }
    }

    for (int i = 0; i < V; i++) {
      if (inDegreeCount[i] == 0) {
        bfs.add(i);
      }
    }

    int i = 0;

    while (!bfs.isEmpty()) {
      int vertex = bfs.poll();
      topoSort[i++] = vertex;
      for (int node : adj.get(vertex)) {
        inDegreeCount[node]--;
        if (inDegreeCount[node] == 0) {
          bfs.add(node);
        }
      }
    }
    return topoSort;
  }

}

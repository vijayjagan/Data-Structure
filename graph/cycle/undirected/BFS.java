package graph.cycle.undirected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {


  class Pair {

    int parent;
    int current;

    public Pair(int parent, int current) {
      this.parent = parent;
      this.current = current;
    }
  }

  boolean checkForCycleViaBFS(int parent, int vertex, ArrayList<ArrayList<Integer>> adj,
      boolean[] visited) {
    Queue<Pair> leveOrder = new LinkedList<>();
    leveOrder.offer(new Pair(parent, vertex));
    while (!leveOrder.isEmpty()) {
      Pair pair = leveOrder.poll();
      int prevVertex = pair.parent;
      int currVertex = pair.current;
      visited[currVertex] = true;
      for (int adjancency : adj.get(currVertex)) {
        if (!visited[adjancency]) {
          leveOrder.offer(new Pair(currVertex, adjancency));
        } else if (adjancency != prevVertex) {
          return  true;
        }
      }
    }
    return false;
  }

  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    Queue<Pair> bfs = new LinkedList<>();
    boolean[] visited = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (checkForCycleViaBFS(-1, i, adj, visited)) {
          return true;
        }
      }
    }
    return false;
  }

}

package graph.shortestpath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUndirectedGraph {

  class Pair {

    int vertex;
    int weight;

    public Pair(int vertex, int weight) {
      this.vertex = vertex;
      this.weight = weight;
    }
  }

  public int[] shortestPath(int[][] edges, int n, int m, int src) {
    int infinity = (int) Math.pow(10, 9);
    int[] distance = new int[n];
    Arrays.fill(distance, infinity);

    List<List<Integer>> adjList = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int from = edge[0];
      int to = edge[1];
      adjList.get(from).add(to);
      adjList.get(to).add(from);
    }

    Queue<Pair> bfs = new ArrayDeque<>();
    bfs.add(new Pair(src, 0));
    distance[src] = 0;

    while (!bfs.isEmpty()) {
      Pair pair = bfs.poll();
      int weight = pair.weight;
      for (int edge : adjList.get(pair.vertex)) {
        if (edge != pair.vertex && weight + 1 <= distance[edge]) {
          distance[edge] = weight + 1;
          bfs.add(new Pair(edge, weight + 1));
        }
      }
    }

    for (int i = 0; i < distance.length; i++) {
      if (distance[i] == infinity) {
        distance[i] = -1;
      }
    }
    return distance;
  }

}

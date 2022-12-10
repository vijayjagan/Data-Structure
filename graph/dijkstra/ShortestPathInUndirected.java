package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathInUndirected {

  static class Pair {

    int node;
    int distance;

    public Pair(int node, int distance) {
      this.node = node;
      this.distance = distance;
    }
  }

  public static List<Integer> shortestPath(int n, int m, int edges[][]) {
    List<List<Pair>> adjacencyList = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      adjacencyList.add(new ArrayList<>());
    }

    for (int[] pair : edges) {
      int from = pair[0];
      int to = pair[1];
      adjacencyList.get(from).add(new Pair(to, pair[2]));
      adjacencyList.get(to).add(new Pair(from, pair[2]));
    }

    int[] distance = new int[n + 1];
    int[] parent = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      distance[i] = (int) Math.pow(10, 9);
    }

    distance[1] = 0;

    Queue<Pair> bfs = new PriorityQueue<>(Comparator.comparing(x -> x.distance));
    bfs.add(new Pair(1, 0));

    while (!bfs.isEmpty()) {
      Pair pair = bfs.poll();
      int parentNode = pair.node;
      int weight = pair.distance;
      for (Pair newPair : adjacencyList.get(parentNode)) {
        int newNode = newPair.node;
        if (distance[newNode] > weight + newPair.distance) {
          distance[newNode] = weight + newPair.distance;
          parent[newNode] = parentNode;
          bfs.offer(new Pair(newNode, distance[newNode]));
        }
      }
    }
    if (distance[n] == (int) Math.pow(10, 9)) {
      return Collections.singletonList(-1);
    }
    List<Integer> result = new ArrayList<>();
    int node = n;
    while (parent[node] != node) {
      result.add(node);
      node = parent[node];
    }
    Collections.reverse(result);
    return result;
  }

  public static void main(String[] args) {
    int[][] edges = new int[][]{
        {1, 2, 2},
        {2, 5, 5},
        {2, 3, 4},
        {1, 4, 1},
        {4, 3, 3},
        {3, 5, 1}
    };
    System.out.println(shortestPath(5, 6, edges));
  }

}

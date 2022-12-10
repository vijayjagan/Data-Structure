package graph;

import graph.LeetCode_127.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode_1976 {

  public int countPaths(int n, int[][] roads) {
    int[] distance = new int[n];
    int[] pathToReach = new int[n];
    Arrays.fill(distance, (int) 1e9);
    distance[0] = 1;
    pathToReach[0] = 1;
    int mod = (int) (1e9) + 7;
    List<List<int[]>> adjacencyList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjacencyList.add(new ArrayList<>());
    }

    for (int[] road : roads) {
      int from = road[0];
      int to = road[1];
      int cost = road[2];
      adjacencyList.get(from).add(new int[]{to, cost});
      adjacencyList.get(to).add(new int[]{from, cost});
    }

    Queue<int[]> bfs = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    bfs.add(new int[]{0, 0});

    while (!bfs.isEmpty()) {
      int[] data = bfs.poll();
      int vertex = data[0];
      int cost = data[1];
      for (int[] neighbour : adjacencyList.get(vertex)) {
        int nextVertex = neighbour[0];
        int newCost = neighbour[1] + cost;
        if (distance[nextVertex] > newCost) {
          distance[nextVertex] = newCost;
          pathToReach[nextVertex] = pathToReach[vertex];
          bfs.offer(new int[]{nextVertex, newCost});
        } else if (distance[nextVertex] == newCost) {
          pathToReach[nextVertex] =  (pathToReach[nextVertex] + pathToReach[vertex]) % mod;
        }
      }
    }
    return pathToReach[n - 1]% mod;
  }

}

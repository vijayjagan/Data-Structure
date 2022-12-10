package graph.dijkstra;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class UsingPriorityQueue {

  static class Pair {

    int node;

    int distance;

    public Pair(int node, int distance) {
      this.node = node;
      this.distance = distance;
    }
  }

  static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
    int[] distance = new int[V];
    Arrays.fill(distance, (int) Math.pow(10, 9));
    distance[S] = 0;

    Queue<Pair> bfs = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));

    bfs.add(new Pair(S, 0));

    while (!bfs.isEmpty()) {
      Pair pair = bfs.poll();
      int vertex = pair.node;
      int weight = distance[vertex];
      for (ArrayList<Integer> neighbourList : adj.get(vertex)) {
        int nVertex = neighbourList.get(0);
        int nWeight = neighbourList.get(1);
        if (distance[nVertex] >= weight + nWeight) {
          distance[nVertex] = weight + nWeight;
          bfs.offer(new Pair(nVertex, weight + nWeight));
        }
      }
    }
    return distance;
  }

}

package graph.mst;

import graph.DisJoinSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kruskals {

  static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
    DisJoinSet disJoinSet = new DisJoinSet(V);
    List<int[]> edges = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      for (ArrayList<Integer> data : adj.get(i)) {
        int to = data.get(0);
        int weight = data.get(1);
        edges.add(new int[]{i, to, weight});
      }
    }
    edges.sort(Comparator.comparingInt(a -> a[2]));
    int totalWeigh = 0;
    for (int[] data : edges) {
      int from = data[0];
      int to = data[1];
      int weight = data[2];
      if (disJoinSet.isSameSet(from, to)) {
        continue;
      }
      disJoinSet.union(from, to);
      totalWeigh += weight;
    }
    return totalWeigh;
  }


}

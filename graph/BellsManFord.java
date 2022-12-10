package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellsManFord {


  static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
    int[] distance = new int[V];
    Arrays.fill(distance, (int) 1e8);
    distance[S] = 0;

    for (int i = 0; i < V; i++) {
      for (ArrayList<Integer> edge : edges) {
        int from = edge.get(0);
        int to = edge.get(1);
        int weight = edge.get(2);
        if (distance[from] + weight < distance[to]) {
          distance[to] = distance[from] + weight;
        }
      }
    }

    for (ArrayList<Integer> edge : edges) {
      int from = edge.get(0);
      int to = edge.get(1);
      int weight = edge.get(2);
      if (distance[from] + weight < distance[to]) {
        return new int[]{-1};
      }
    }
    return distance;
  }


}

package graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import jdk.internal.util.xml.impl.Pair;

public class ShortestPathInDAGViaTopoSort {

  class Pair {

    int to;
    int weight;

    public Pair(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }


  static void topoSortViaDFS(int vertex, int[] visited, List<List<Pair>> adjList,
      Stack<Integer> topoSort) {
    visited[vertex] = 1;
    for (Pair pair : adjList.get(vertex)) {
      int node = pair.to;
      if (visited[node] == 0) {
        topoSortViaDFS(node, visited, adjList, topoSort);
      }
    }
    topoSort.add(vertex);
  }

  public int[] shortestPath(int N, int M, int[][] edges) {
    List<List<Pair>> adjList = new ArrayList<>();
    Stack<Integer> topoSort = new Stack<>();
    int[] visited = new int[N];

    for (int i = 0; i < N; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int[] data : edges) {
      int from = data[0];
      int to = data[1];
      int weight = data[2];
      adjList.get(from).add(new Pair(to, weight));
    }

    for (int i = 0; i < N; i++) {
      if (visited[i] == 0) {
        topoSortViaDFS(i, visited, adjList, topoSort);
      }
    }

    int[] distanceFromSource = new int[N];
    Arrays.fill(distanceFromSource, -1);
    // Since 0 is the Source
    distanceFromSource[0] = 0;
    while (!topoSort.isEmpty()) {
      int vertex = topoSort.pop();
      int distance = distanceFromSource[vertex];
      for (Pair adjPair : adjList.get(vertex)) {
        int node = adjPair.to;
        int weight = adjPair.weight;
        if (distanceFromSource[node] > distance + weight) {
          distanceFromSource[node] = distance + weight;
        }
      }
    }
    for (int i = 0; i < distanceFromSource.length; i++) {
      if (distanceFromSource[i] == Math.pow(10, 9)) {
        distanceFromSource[i] = -1;
      }
    }
    return distanceFromSource;
  }

}

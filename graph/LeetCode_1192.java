package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_1192 {

//  static void depthFirstSearch(int vertex, int[] visited)


  public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    int[] discoveryTime = new int[n];
    int[] lowestTime = new int[n];

    List<List<Integer>> adjacencyList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjacencyList.add(i, new ArrayList<>());
    }
    for (List<Integer> connection : connections) {
      int from = connection.get(0);
      int to = connection.get(1);
      List<Integer> neighbours = adjacencyList.get(from);
      neighbours.add(to);
      adjacencyList.add(from, neighbours);
      List<Integer> reverseList = adjacencyList.get(to);
      reverseList.add(from);
    }
    System.out.println(adjacencyList);
    return null;
  }

  public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList<>();
    list.add(new ArrayList<>(Arrays.asList(0, 1)));
    list.add(new ArrayList<>(Arrays.asList(1, 2)));
    list.add(new ArrayList<>(Arrays.asList(2, 0)));
    list.add(new ArrayList<>(Arrays.asList(1, 3)));
    System.out.println(criticalConnections(4, list));
  }

}

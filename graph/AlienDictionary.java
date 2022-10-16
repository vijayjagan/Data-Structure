package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {

  public static String findOrder(String[] dict, int N, int K) {
    List<List<Integer>> adjList = new ArrayList<>();

    for (int i = 0; i < K; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      String s1 = dict[i];
      String s2 = dict[i + 1];
      int length = Math.min(s1.length(), s2.length());
      for (int j = 0; j < length; j++) {
        if (s1.charAt(j) != s2.charAt(j)) {
          adjList.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
          break;
        }
      }
    }

    int[] inDegreeCount = new int[K];
    List<Character> topoSort = new ArrayList<>();
    Queue<Integer> bfs = new ArrayDeque<>();

    for (int i = 0; i < K; i++) {
      for (int vertex : adjList.get(i)) {
        inDegreeCount[vertex]++;
      }
    }

    for (int i = 0; i < K; i++) {
      if (inDegreeCount[i] == 0) {
        bfs.add(i);
      }
    }

    while (!bfs.isEmpty()) {
      int vertex = bfs.poll();
      topoSort.add((char) (vertex + 'a'));

      for (int node : adjList.get(vertex)) {
        inDegreeCount[node]--;
        if (inDegreeCount[node] == 0) {
          bfs.add(node);
        }
      }
    }

    StringBuilder s = new StringBuilder();
    for (char c : topoSort) {
      s.append(c);
    }
    return s.toString();
  }

  public static void main(String[] args) {
    String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
    System.out.println(findOrder(dict, dict.length, 4));
  }
}

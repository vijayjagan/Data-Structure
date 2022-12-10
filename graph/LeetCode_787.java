package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode_787 {


  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    List<List<int[]>> adjacencyList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjacencyList.add(new ArrayList<>());
    }
    int[] distance = new int[n];
    Arrays.fill(distance, (int) 1e9);

    for (int[] flight : flights) {
      int from = flight[0];
      int to = flight[1];
      int cost = flight[2];
      adjacencyList.get(from).add(new int[]{to, cost});
    }
    Queue<int[]> bfs = new ArrayDeque<>();
    bfs.add(new int[]{src, 0, 0});
    distance[src] = 0;

    while (!bfs.isEmpty()) {
      int[] poll = bfs.poll();
      int city = poll[0];
      int cost = poll[1];
      int stop = poll[2];

      if (city == dst) {
        return cost;
      }

      for (int[] neighbour : adjacencyList.get(city)) {
        int nextCity = neighbour[0];
        int amountToTravel = neighbour[1];
        if (distance[nextCity] > cost + amountToTravel) {
          distance[nextCity] = cost + amountToTravel;
          bfs.offer(new int[]{nextCity, distance[nextCity], stop + 1});
        }
      }
    }
    return distance[dst] == 1e9 ? -1 : distance[dst];
  }

//  [0, 0, 0]
//[3, 2, 1]
//[1, 4, 2]
//[1, 5, 1]
//[4, 5, 3]
//[2, 9, 3]


//  [0, 0, 0]
//[1, 5, 1]
//[3, 2, 1]
//[2, 10, 2]
//[4, 6, 2]
//[1, 4, 2]
//[2, 7, 3]
//[4, 5, 3]
}

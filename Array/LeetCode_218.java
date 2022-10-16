package Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode_218 {

  public List<List<Integer>> getSkyline(int[][] buildings) {
    List<List<Integer>> result = new ArrayList<>();
    List<int[]> height = new ArrayList<>();
    for (int[] b : buildings) {
      height.add(new int[]{b[0], -b[2]});
      height.add(new int[]{b[0], b[2]});
    }
    height.sort(Comparator.comparingInt(a -> a[0]));
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
    pq.offer(0);
    int prev = 0;
    for (int i = 0; i < height.size(); i++) {
      int[] h = height.get(i);
      if (h[1] < 0) {
        pq.offer(-h[1]);
      } else {
        pq.remove(h[1]);
      }
      if (i < height.size() - 1 && height.get(i + 1)[0] == h[0]) {
        continue;
      }
      int cur = pq.peek();
      if (prev != cur) {
        List<Integer> point = new ArrayList<>();
        point.add(h[0]);
        point.add(cur);
        result.add(point);
        prev = cur;
      }
    }
    return result;
  }

}

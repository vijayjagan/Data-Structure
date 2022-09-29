package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class LeetCode_658 {


  public static List<Integer> findClosestElements(int[] arr, int k, int x) {
    Map<Integer, Queue<Integer>> valueWithList = new TreeMap<>();

    for (int i : arr) {
      int diff = Math.abs(x - i);
      Queue<Integer> priority = valueWithList.getOrDefault(diff, new PriorityQueue<>());
      priority.offer(i);
      valueWithList.put(diff, priority);
    }
    List<Integer> closetQueue = new ArrayList<>();
    for (Map.Entry<Integer, Queue<Integer>> entry : valueWithList.entrySet()) {
      Queue<Integer> value = entry.getValue();
      while (!value.isEmpty()) {
        int finalValue = value.poll();
        if (k != 0) {
          k--;
          closetQueue.add(finalValue);
        }
      }
    }
    return closetQueue;
  }

  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 10, 10, 10};
    int k = 1, x = 9;
    System.out.println(findClosestElements(arr, k, x));
  }

}

package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode_2136 {

  public static int earliestFullBloom(int[] plantTime, int[] growTime) {
    Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    for (int i = 0; i < plantTime.length; i++) {
      queue.offer(new int[]{plantTime[i], growTime[i]});
    }
    int previousPlantDay = 0; // since day starts from zero
    int maxDay = 0;

    while (!queue.isEmpty()) {
      int[] plant = queue.poll();
      System.out.println(Arrays.toString(plant));
      int currentPlantDay = previousPlantDay;
      maxDay = Math.max(maxDay, currentPlantDay + plant[0] + plant[1]);
      previousPlantDay += plant[0];
    }
    return maxDay;
  }


  public static void main(String[] args) {
    int[] plantTime = {1, 4, 3};
    int[] growTime = {2, 3, 1};
    System.out.println(earliestFullBloom(plantTime, growTime));
  }
}

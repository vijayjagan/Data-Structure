package dynamicprogramming.arrays;

import java.util.Arrays;
import java.util.Date;

public class LeetCode_983 {


  static int minCostTickets(int index, int[] days, int[] costs, int[] cache) {
    if (index >= days.length) {
      return 0;
    }

    if (cache[index] != -1) {
      return cache[index];
    }

    int oneDay = costs[0] + minCostTickets(index + 1, days, costs, cache);

    int nextIndex;
    for (nextIndex = index; nextIndex < days.length && days[nextIndex] <= days[index] + 6;
        nextIndex++);

    int sevenDay = costs[1] + minCostTickets(nextIndex, days, costs, cache);
    for (nextIndex = index; nextIndex < days.length && days[nextIndex] <= days[index] + 29;
        nextIndex++);
    int thirtyDay = costs[2] + minCostTickets(nextIndex, days, costs, cache);

    return cache[index] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
  }

  public int mincostTickets(int[] days, int[] costs) {
    int[] cache = new int[days.length + 1];
    Arrays.fill(cache, -1);
    return minCostTickets(0, days, costs, cache);
  }

  public static void main(String[] args) {
    int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
    int[] costs = {2, 7, 15};
    System.out.println(new LeetCode_983().mincostTickets(days, costs));
  }

}

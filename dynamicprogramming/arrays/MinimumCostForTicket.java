package dynamicprogramming.arrays;

import java.util.Arrays;

public class MinimumCostForTicket {


  /**
   * Start from index 0 try out all the possibilities For an instance, we start at index 0
   * <p>
   * 0th index have three possibilities we can buy first day pass or else we can try second day pass
   * or else we can buy third day pass
   * <p>
   * <p>
   * ONE DAY PASS If we buy one day pass we can directly shift to next day aka next index(Left Out
   * days doesn't matter since we completed one day mission accomplished) ex:- [1, 7 , 47 , 568]; =>
   * index 0 if we buy one day pass we can move to next index or 7th day Between days doesn't
   * matter
   * <p>
   * SEVENTH DAY PASS If we buy seventh day pass we need to identify the current day + 7 day (ex :
   * current you are at 4th day if you buy the pass on this day 4 + 7 = 11 , we need to identify the
   * index which is greater than or equal to 11);
   * <p>
   * Min of all This is the result
   * <p>
   * At the base case reason to return 0 is we are adding the value we didn't want to mess the
   * previous result,
   */

  static int calculateNextIndex(int travelCompletedDay, int[] days) {
    for (int i = 0; i < days.length; i++) {
      if (days[i] >= travelCompletedDay) {
        return i;
      }
    }
    return -1;
  }

  static int minimumCost(int[] days, int[] cost, int index, int[] cache) {
    if (index == -1 || index == days.length) {
      return 0;
    }
    if (cache[index] != -1) {
      return cache[index];
    }
    int oneDayPass = cost[0] + minimumCost(days, cost, index + 1, cache);
    int sevenDayPass =
        cost[1] + minimumCost(days, cost, calculateNextIndex(days[index] + 7, days), cache);
    int thirtyDayPass =
        cost[2] + minimumCost(days, cost, calculateNextIndex(days[index] + 30, days), cache);
    return cache[index] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
  }


  public static int mincostTickets(int[] days, int[] costs) {
    int[] cache = new int[days.length];
    Arrays.fill(cache, -1);
    return minimumCost(days, costs, 0, cache);
  }

  public static void main(String[] args) {
    int[] days = { 7, 8, 20};
    int[] cost = {1, 2, 15};
    System.out.println(mincostTickets(days, cost));
  }
}

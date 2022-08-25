package dynamicprogramming.knapsack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeetCode_1553 {


  static int minimumDays(int oranges, int[] cache) {

    if (oranges == 0) {
      return 0;
    }

    if (cache[oranges] != -1) {
      return cache[oranges];
    }

    int pickBy2Orange = (int) Math.pow(10, 9), pickBy3Orange = (int) Math.pow(10, 9);

    int pickOneOrange = 1 + minimumDays(oranges - 1, cache);

    if (oranges % 2 == 0) {
      pickBy2Orange = 1 + minimumDays(oranges - (oranges / 2), cache);
    }

    if (oranges % 3 == 0) {
      pickBy3Orange = 1 + minimumDays(oranges - (2 * (oranges / 3)), cache);
    }

    return cache[oranges] = 1 + Math.min(pickOneOrange, Math.min(pickBy2Orange, pickBy3Orange));
  }
  
  public static int minDaysUsingTabulation(int oranges) {
    int[] cache = new int[oranges + 1];

    for (int i = 1; i <= oranges; i++) {
      int pickBy2Orange = (int) Math.pow(10, 9), pickBy3Orange = (int) Math.pow(10, 9);
      int pickOneOrange = 1 + cache[i - 1];
      if (i % 2 == 0) {
        pickBy2Orange = 1 + cache[i - (i / 2)];
      }
      if (i % 3 == 0) {
        pickBy3Orange = 1 + cache[i - (2 * (i / 3))];
      }
      cache[i] = Math.min(pickOneOrange, Math.min(pickBy2Orange, pickBy3Orange));
    }
    return cache[oranges];
  }

  public static int minDays(int n) {
    int [] cache = new int[n + 1];
    Arrays.fill(cache, -1);
    return minimumDays(n, cache);
  }

  public static void main(String[] args) {
    System.out.println(minDays(2338692));
  }

}

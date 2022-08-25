package dynamicprogramming.knapsack;

import java.util.Arrays;

public class LeetCode_1402 {

  static int maxSatisfaction(int index, int time, int[] satisfaction, Integer[][] cache) {
    if (index == satisfaction.length) {
      return 0;
    }

    if (cache[index][time] != null) {
      return cache[index][time];
    }

    int pick =
        satisfaction[index] * time + maxSatisfaction(index + 1, time + 1, satisfaction, cache);
    int notPick = maxSatisfaction(index + 1, time, satisfaction, cache);
    return cache[index][time] = Math.max(pick, notPick);
  }

  public static int maxSatisfaction(int[] satisfaction) {
    Arrays.sort(satisfaction);
    Integer[][] cache = new Integer[satisfaction.length][satisfaction.length + 1];
    return maxSatisfaction(0, 1, satisfaction, cache);
  }

  public static void main(String[] args) {
    int[] satisfaction = {-1, -4, -5};
    System.out.println(maxSatisfaction(satisfaction));
  }

}

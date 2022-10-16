package dynamicprogramming.arrays;

import java.util.Arrays;

public class LeetCode_1335 {


  int findMinDays(int pointer, int days, int[] jobDifficulty, int n, Integer[][] cache) {
    if (pointer == n) {
      return (int) Math.pow(10, 9);
    }
    if (days == 1) {
      int max = jobDifficulty[pointer];
      for (int i = pointer + 1; i < n; i++) {
        max = Math.max(jobDifficulty[i], max);
      }
      return max;
    }
    if (cache[pointer][days] != null) {
      return cache[pointer][days];
    }
    int minDifficulty = Integer.MAX_VALUE;
    int maxDay = Integer.MIN_VALUE;

    for (int i = pointer; i < n; i++) {
      maxDay = Math.max(maxDay, jobDifficulty[i]);
      minDifficulty = Math.min(minDifficulty,
          maxDay + findMinDays(i + 1, days - 1, jobDifficulty, n, cache));
    }
    return cache[pointer][days] = minDifficulty;
  }

  int findMinDays(int days, int[] jobDifficulty) {
    int[][] cache = new int[jobDifficulty.length + 1][days + 1];
    int arrLength = jobDifficulty.length;
    // Edge Case
    for (int i = 0; i <= days; i++) {
      cache[arrLength][i] = (int) Math.pow(10, 9);  
    }
    // Base Case
    for (int i = 0; i < arrLength; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = i; j < arrLength; j++) {
        max = Math.max(max, jobDifficulty[j]);
      }
      cache[i][1] = max;
    }

    for (int pointer = arrLength - 1; pointer > -1; pointer--) {
      for (int day = 2; day <= days; day++) {
        int minDifficulty = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for (int i = pointer; i < arrLength; i++) {
          maxDay = Math.max(maxDay, jobDifficulty[i]);
          minDifficulty = Math.min(minDifficulty, maxDay + cache[i + 1][day - 1]);
        }
        cache[pointer][days] = minDifficulty;
      }
    }
    for (int [] value : cache) {
      System.out.println(Arrays.toString(value));
    }
    return cache[0][days];
  }

  public int minDifficulty(int[] jobDifficulty, int d) {
    if (jobDifficulty.length < d) {
      return -1;
    }
    Integer[][] cache = new Integer[jobDifficulty.length][d + 1];
    return findMinDays(d, jobDifficulty);
  }

  public static void main(String[] args) {
    int[] jobDifficulty = {1, 1, 1};
    System.out.println(new LeetCode_1335().minDifficulty(jobDifficulty, 3));
  }

}

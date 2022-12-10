package dynamicprogramming.arrays;

import java.util.Arrays;

public class LeetCode_70 {


  public int climbStairs(int n, int[] cache) {
    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    if (cache[n] != -1) {
      return cache[n];
    }
    return cache[n] = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
  }

  public int climbStairs(int n) {
    int[] cache = new int[n + 1];
    cache[0] = 1;
    cache[1] = 1;
    for (int i = 2; i <= n; i++) {
      cache[i] = cache[i - 1] + cache[i - 2];
    }
    return cache[n];
  }

  public static void main(String[] args) {
    System.out.println(new LeetCode_70().climbStairs(10));
  }


}

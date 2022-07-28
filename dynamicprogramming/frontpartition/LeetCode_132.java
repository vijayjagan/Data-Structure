package dynamicprogramming.frontpartition;

import java.util.Arrays;

public class LeetCode_132 {


  static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left++) != s.charAt(right--)) {
        return false;
      }
    }
    return true;
  }

  static int getMinimumCut(int left, char[] array, int[] cache) {
    if (left == array.length) {
      return 0;
    }
    if (cache[left] != -1) {
      return cache[left];
    }
    StringBuilder currentAppend = new StringBuilder();
    int minCost = array.length;
    for (int i = left; i < array.length; i++) {
      currentAppend.append(array[i]);
      if (isPalindrome(currentAppend.toString())) {
        minCost = Math.min(1 + getMinimumCut(i + 1, array, cache), minCost);
      }
    }
    return cache[left] = minCost;
  }

  static int tabulation(String s) {
    int[] cache = new int[s.length() + 1];
    for (int i = s.length() - 1; i >= 0; i--) {
      int minCost = Integer.MAX_VALUE;
      StringBuilder currentAppend = new StringBuilder();
      for (int j = i; j < s.length(); j++) {
        currentAppend.append(s.charAt(j));
        if (isPalindrome(currentAppend.toString())) {
          int cost = 1 + cache[j + 1];
          minCost = Math.min(cost, minCost);
        }
      }
      cache[i] = minCost;
    }
    return cache[0] - 1;
  }

  public static int minCut(String s) {
    int[] cache = new int[s.length()];
    Arrays.fill(cache, -1);
    return getMinimumCut(0, s.toCharArray(), cache);
  }

  public static void main(String[] args) {
    System.out.println(tabulation("aab"));
  }
}

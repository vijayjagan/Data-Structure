package greedy;

import java.util.Arrays;

public class LeetCode_1578 {

  public static int minCost(String colors, int[] neededTime) {
    int length = colors.length();
    char[] colorArray = colors.toCharArray();
    int totalCost = 0;
    int maxCost = 0;

    for (int i = 0; i < length; i++) {
      char currentColor = colorArray[i];
      int localMax = 0;
      while (i + 1 < length && currentColor == colorArray[i + 1]) {
        localMax = Math.max(localMax, Math.max(neededTime[i], neededTime[i++ + 1]));
      }
      maxCost += Math.max(localMax, neededTime[i]);
    }

    for (int time : neededTime) {
      totalCost += time;
    }
    
    return totalCost - maxCost;
  }

  public static void main(String[] args) {
    String colors = "aaabbbabbbb";
    int[] neededTime = {3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1};

    System.out.println(minCost(colors, neededTime));
  }

}

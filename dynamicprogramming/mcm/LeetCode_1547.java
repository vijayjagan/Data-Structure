package dynamicprogramming.mcm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import jdk.jfr.Description;

public class LeetCode_1547 {

  @Description("Recursion + Memoization")
  static int minimumCost(int leftPointer, int rightPointer, List<Integer> cuttingPortion,
      Integer[][] cache) {
    if (leftPointer > rightPointer) {
      return 0;
    }
    if (cache[leftPointer][rightPointer] != null) {
      return cache[leftPointer][rightPointer];
    }
    int minCost = Integer.MAX_VALUE;
    for (int i = leftPointer; i <= rightPointer; i++) {
      int cost = Math.abs(
          cuttingPortion.get(leftPointer - 1) - cuttingPortion.get(rightPointer + 1));
      int left = minimumCost(leftPointer, i - 1, cuttingPortion, cache);
      int right = minimumCost(i + 1, rightPointer, cuttingPortion, cache);
      minCost = Math.min(cost + left + right, minCost);
    }
    return cache[leftPointer][rightPointer] = minCost;
  }

  @Description("Tabulation to avoid stack space of recursion")
  static int minCostViaTabulation(int n, int[] cuts) {
    Arrays.sort(cuts);
    int initLength = cuts.length;
    List<Integer> cuttingPortion = Arrays.stream(cuts).boxed().collect(Collectors.toList());
    cuttingPortion.add(0, 0);
    cuttingPortion.add(cuttingPortion.size(), n);
    int[][] cache = new int[cuttingPortion.size()][cuttingPortion.size()];

    for (int leftPointer = initLength; leftPointer > 0; leftPointer--) {
      for (int rightPointer = 1; rightPointer <= initLength; rightPointer++) {
        if (leftPointer > rightPointer) {
          continue;
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = leftPointer; i <= rightPointer; i++) {
          int cost = Math.abs(
              cuttingPortion.get(leftPointer - 1) - cuttingPortion.get(rightPointer + 1));
          int left = cache[leftPointer][i - 1];
          int right = cache[i + 1][rightPointer];
          minCost = Math.min(cost + left + right, minCost);
        }
        cache[leftPointer][rightPointer] = minCost;
      }
    }
    return cache[1][initLength];
  }

  public static int minCost(int n, int[] cuts) {
    Arrays.sort(cuts);
    int initLength = cuts.length;
    List<Integer> cuttingPortion = Arrays.stream(cuts).boxed().collect(Collectors.toList());
    cuttingPortion.add(0, 0);
    cuttingPortion.add(cuttingPortion.size(), n);
    Integer[][] cache = new Integer[cuttingPortion.size()][cuttingPortion.size()];
    return minimumCost(1, initLength, cuttingPortion, cache);
  }

  public static void main(String[] args) {
    int[] cuts = {1, 3, 4, 5};
    int n = 7;
    System.out.println(minCostViaTabulation(n, cuts));
  }

}

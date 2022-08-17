package dynamicprogramming.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class PizzaWith3N {


  static int maxSlice(int index, int endIndex, int totalRounds, int[] slices, Integer[][] cache) {

    if (index >= endIndex || totalRounds == 0) {
      return 0;
    }

    if (cache[index][totalRounds] != null) {
      return cache[index][totalRounds];
    }

    // If you pick up the slice will end up in the second piece from the index
    int pick = slices[index] + maxSlice(index + 2, endIndex, totalRounds - 1, slices, cache);
    int notPick = maxSlice(index + 1, endIndex, totalRounds, slices, cache);

    return cache[index][totalRounds] = Math.max(pick, notPick);
  }

  public int maxSizeSlices(int[] slices) {

    int totalRounds = slices.length / 3;
    Integer[][] cache = new Integer[slices.length][totalRounds + 1];
    Integer[][] cacheTwo = new Integer[slices.length][totalRounds + 1];

    int pickFirstElementAndExcludeLast = maxSlice(0, slices.length - 1, totalRounds, slices, cache);
    int pickSecondElementAndIncludeLast = maxSlice(1, slices.length , totalRounds, slices, cacheTwo);

    return Math.max(pickFirstElementAndExcludeLast, pickSecondElementAndIncludeLast);
  }

  public static void main(String[] args) {
    int[] slices = {1,2,3};
    int result = new PizzaWith3N().maxSizeSlices(slices);
    System.out.println(result);
  }

}

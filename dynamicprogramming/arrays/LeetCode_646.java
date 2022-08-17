package dynamicprogramming.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_646 {

  public static int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
    int result = 1;
    int right = pairs[0][1];
    for (int i = 1; i < pairs.length; i++) {
      if (right < pairs[i][0]) {
        result++;
        right = pairs[i][1];
      }
    }
    return result;
  }


  public static void main(String[] args) {
    int[][] pairs = {{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}};
    Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
    System.out.println(findLongestChain(pairs));
  }
}

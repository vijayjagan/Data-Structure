package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_1996 {


  public int numberOfWeakCharacters(int[][] properties) {
    Arrays.sort(properties, (a, b) -> (b[0] == a[0]) ? (a[1] - b[1]) : b[0] - a[0]);
    System.out.println(Arrays.deepToString(properties));
    int max = 0;
    int count = 0;
    for (int[] property : properties) {
      if (property[1] < max) {
        count++;
      }
      max = Math.max(max, property[1]);
    }
    return count;
  }

  public static void main(String[] args) {
    int[][] properties = new int[][]{
        {1, 0},
        {2, 1},
        {2, 2},
        {1, 2}
    };
    System.out.println(new LeetCode_1996().numberOfWeakCharacters(properties));
  }

}

package backtracking;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_967 {


  static void traceNextNumber(int i, int diff, int limit, int number, Set<Integer> list) {

    if (list.contains(number)) {
      return;
    }

    if (limit == 1) {
      list.add(number);
      return;
    }

    if (i + diff < 10) {
      traceNextNumber(i + diff, diff, limit - 1, (number * 10) + i + diff, list);
    }

    if (i - diff >= 0) {
      traceNextNumber(i - diff, diff, limit - 1, (number * 10) + i - diff, list);
    }
  }

  public int[] numsSameConsecDiff(int n, int k) {
    Set<Integer> list = new HashSet<>();

    for (int i = 1; i <= 9; i++) {
      traceNextNumber(i, k, n, i, list);
    }

    int[] result = new int[list.size()];
    int i = 0;

    for (Integer value : list) {
      result[i++] = value;
    }

    return result;
  }

  public static void main(String[] args) {
    new LeetCode_967().numsSameConsecDiff(2, 0);
  }
}

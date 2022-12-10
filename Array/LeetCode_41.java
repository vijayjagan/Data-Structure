package Array;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_41 {

  public static int firstMissingPositive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int max = Integer.MIN_VALUE;
    for (int val : nums) {
      set.add(val);
      max = Math.max(val ,max);
    }
    for (int i = 1; i < max; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return 1;
  }


  public static void main(String[] args) {
    System.out.println(firstMissingPositive(new int[]{-1, -2, -60, 40, 43}));
  }

}

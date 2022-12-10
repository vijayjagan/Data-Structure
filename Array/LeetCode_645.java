package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode_645 {

  public int[] findErrorNums(int[] nums) {
    Arrays.sort(nums);
    Set<Integer> tracker = new HashSet<>();
    int missingValue = 1;
    int duplicate = 0;
    for (int num : nums) {
      if (tracker.contains(num)) {
        duplicate = num;
        continue;
      }
      tracker.add(num);
      if (missingValue == num) {
        missingValue++;
      }
    }
    return new int[]{duplicate, missingValue};
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(new LeetCode_645().findErrorNums(new int[]{1, 5, 3, 2, 2, 7, 6, 4, 8, 9})));
  }

}

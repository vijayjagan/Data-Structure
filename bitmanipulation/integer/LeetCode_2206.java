package bitmanipulation.integer;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_2206 {

  public boolean divideArray(int[] nums) {
    Set<Integer> visitedValue = new HashSet<>();
    for (int num : nums) {
      if (visitedValue.contains(num)) {
        visitedValue.remove(num);
      }
      visitedValue.add(num);
    }

    return visitedValue.isEmpty();
  }

}

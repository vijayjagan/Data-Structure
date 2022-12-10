package Array;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_219 {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> indexTracker = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (indexTracker.containsKey(nums[i]) && Math.abs(i - indexTracker.get(nums[i])) <= k) {
        return true;
      }
      indexTracker.put(nums[i], i);
    }
    return false;
  }
}


package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode_1207 {


  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer,Integer> countMap = new HashMap<>();
    for (int val : arr) {
      countMap.put(val, countMap.getOrDefault(val, 0) + 1);
    }
    return new HashSet<>(countMap.values()).size() == countMap.size();
  }

}
